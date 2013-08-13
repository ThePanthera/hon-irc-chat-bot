package com.honchatlib.authentication;

import com.honchatlib.Commons;
import com.honchatlib.Commons;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Random;
import lombok.Setter;

/**
 * Heroes of Newerth authentication.
 * 
 * Based on the paper by Tom Wu: The Secure Remote Password Protocol
 * 1998 Internet Society Network and Distributed System Security Symposium
 * San Diego, CA, Mar 1998
 * 
 * TO USE: Create an object, passing in the username and password. Call generateA() and
 * send the result to the master server. Call generateM() and pass salt, salt2, and B
 * as Strings. Send the result (proof) to the Master Server to Authenticate.
 * 
 * Note that generateA() MUST be called before generateM().
 * 
 * @author Steve Legere (AncienT)
 *
 */
public class SRPAuth
{
    @Setter private String username;
    @Setter private String password;
    private byte[ ] a;
    private byte[ ] A;
    private byte[ ] B;
    private byte[ ] g;
    private byte[ ] k;
    private byte[ ] K;
    private byte[ ] N;
    private byte[ ] s;
    private byte[ ] S;
    private byte[ ] u;
    private byte[ ] x;
    private MessageDigest sha256;

    /**
     * 
     * @param username - Username as String
     * @param password - Password as String
     */
    public SRPAuth( String username, String password ) throws java.security.NoSuchAlgorithmException
    {
        this.username = username;
        this.password = Commons.md5( password );

        N = Commons.toByteArray(
                "DA950C6C97918CAE89E4F5ECB32461032A217D740064BC12FC0723CD204BD02A"
                + "7AE29B53F3310C13BA998B7910F8B6A14112CBC67BDD2427EDF494CB8BCA6851"
                + "0C0AAEE5346BD320845981546873069B337C073B9A9369D500873D647D261CCE"
                + "D571826E54C6089E7D5085DC2AF01FD861AE44C8E64BCA3EA4DCE942C5F5B89E"
                + "5496C2741A9E7E9F509C261D104D11DD4494577038B33016E28D118AE4FD2E85"
                + "D9C3557A2346FAECED3EDBE0F4D694411686BA6E65FEE43A772DC84D394ADAE5"
                + "A14AF33817351D29DE074740AA263187AB18E3A25665EACAA8267C16CDE064B1"
                + "D5AF0588893C89C1556D6AEF644A3BA6BA3F7DEC2F3D6FDC30AE43FBD6D144BB" );
        
        g = Commons.toByteArray( "2" );
    }
    
    public String generateA( )
    {
        a = Commons.toByteArray( new BigInteger( 2048, new Random( ) ).toString( 16 ) );
        A = Commons.toByteArray( new BigInteger( 1, g ).modPow( new BigInteger( 1, a ), new BigInteger( 1, N ) ).toString( 16 ) );
        
        return Commons.toHexString( A );
    }
    
    /**
     * Used to generate the proof value used to authenticate to the master server.
     * 
     * @param salt Salt from Server as Hex String
     * @param salt2 Salt2 from Server as Hex String
     * @param B B from Server as Hex String
     * @return M1 as Hex String
     */
    public String generateM( String salt, String salt2, String BString )
    {
        this.s = Commons.toByteArray( salt );
        this.B = Commons.toByteArray( BString );
        
        try
        {
            sha256 = MessageDigest.getInstance( "SHA-256" );
            
            // Calculate k = H( N, PAD( g ) )
            sha256.update( N );
            sha256.update( Commons.PAD( g, N.length ) );
            k = sha256.digest( );
            
            // Calculate new password (Custom S2 Implementation)
            password = S2_SaltedPassword( password, salt2 );
            
            // Calculate u = H( PAD( A ), PAD( B ) )
            sha256.update( A );
            sha256.update( B );
            u = sha256.digest( );
            
            // Calculate x = H( s, H( u:p ) )
            byte[ ] up = sha256.digest( ( username + ":" + password ).getBytes( ) );
            sha256.update( s );
            sha256.update( up );
            x = sha256.digest( );
            
            // Calculate S = ( B ? kg^x ) ^ ( a + ux )
            // Note that positive numbers are being forced here.
            BigInteger BN = new BigInteger( 1, this.N );
            BigInteger BB = new BigInteger( 1, this.B );
            BigInteger Bk = new BigInteger( 1, this.k );
            BigInteger Bg = new BigInteger( 1, this.g );
            BigInteger Bx = new BigInteger( 1, this.x );
            BigInteger Ba = new BigInteger( 1, this.a );
            BigInteger Bu = new BigInteger( 1, this.u );
            
            // Manually convert to byte array.
            BigInteger BS = BB.subtract( Bk.multiply( Bg.modPow( Bx, BN ) ) ).modPow( Ba.add( Bu.multiply( Bx ) ), BN );
            S = Commons.toByteArray( BS.toString( 16 ) );
            
            // Calculate K = H( S )
            K = sha256.digest( S );
            
            // Calculate M1 = H[ H( N ) XOR H( PAD( g ) ) | H( username ) | s | A | B | K ]
            byte[ ] HNXORg = Commons.XOR( sha256.digest( N ), sha256.digest( Commons.PAD( g, N.length ) ) );
            byte[ ] Husername = sha256.digest( username.getBytes( ) );
            
            sha256.update( HNXORg );
            sha256.update( Husername );
            sha256.update( s );
            sha256.update( A );
            sha256.update( B );
            sha256.update( K );
            
            byte[ ] M1 = sha256.digest( );
            
            return Commons.toHexString( M1 );
        }
        catch( Exception e )
        {
            e.printStackTrace( );
        }
        
        return null;
    }
    
    /**
     * Based on k2.dll
     * 
     * @param password Password as Hex String
     * @param salt2 Salt2 from Server as String
     */
    private String S2_SaltedPassword( String password, String salt2 ) throws java.security.NoSuchAlgorithmException
    {
        String constant1 = "[!~esTo0}";
        String constant2 = "taquzaph_?98phab&junaj=z=kuChusu";
        
        return Commons.sha256( Commons.md5( password + salt2 + constant1 ) + constant2 );
    }
}
