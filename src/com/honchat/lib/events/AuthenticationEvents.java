package com.honchat.lib.events;

/**
 *
 * @author _4Char
 */
public interface AuthenticationEvents
{
    // Called upon a successful authentication to HoN's masterserver
    public abstract void onConnect( String username );
    // Called upon disconnect (idk?) 
    public abstract void onDisconnect( );
    
    // Called upon a connection attempt to HoN's masterserver
    public abstract void onConnectAttempt( String username );
    // Called upon a failed connection attempt to HoN's masterserver
    public abstract void onConnectAttemptFail( String username, String reason );
}
