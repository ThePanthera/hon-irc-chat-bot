package com.honchatlib.events;

/**
 *
 * @author _4Char
 */
public interface ChatEvents
{
    // Called upon a successful authentication to the chat server
    public abstract void onConnect( String username );
    // Called upon disconnect (idk?) 
    public abstract void onDisconnect( );
    
    // Called upon a connection attempt to the chat server
    public abstract void onConnectAttempt( String username );
    // Called upon a failed connection attempt to the chat server
    public abstract void onConnectAttemptFail( String username, String reason );
    
    // Called once a channel is joined
    public abstract void onJoinChannel( int channelId );
    // Called once a channel is left
    public abstract void onLeaveChannel( int channelId );
    // Called when you're kicked from a channel
    public abstract void onKickedFromChannel( int channelId, String reason );
    
    // Called when a user joins a channel you're in
    public abstract void onUserJoinChannel( int channelId, int userId );
    // Called when a user in a channel leaves that channel
    public abstract void onUserLeaveChannel( int channelId, int userId );
    // Called when a user in a channel is kicked from that channel
    public abstract void onUserKickedFromChannel( int channelId, int userId, String reason );
    // Called when a user in a channel sets the topic for that channel
    public abstract void onUserSetChannelTopic( int channelId, int userId, String topic );
    // Called when a user in a channel sets the mode for another user
    public abstract void onUserSetMode( int channelId, int userId, int mode );
    // Called when a user sends a message to a channel
    public abstract void onUserSay( int channelId, int userId, String message );
    // Called when a user sends an emote to a channel
    public abstract void onUserEmote( int channelId, int userId, String message );
    // Called when a user sends a roll message to a channel
    public abstract void onUserRoll( int channelId, int userId, String message );
    
    // Called when a user sends a private message to you
    public abstract void onPrivateMessage( int userId, String message );
    // Called when a user whispers you
    public abstract void onWhisperMessage( int userId, String message );
    
    // Called when you receive any message
    public abstract void onReceiveRaw( String message );
}