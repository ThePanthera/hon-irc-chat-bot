package com.honchat.lib.protocol;

/**
 *
 * @author _4Char
 */
public interface Protocol
{
    // Generic Constants
    public static final int HON_CHAT_PORT = 11031;
    public static final byte HON_PROTOCOL_VERSION = 43;

    public static final int HON_STATUS_OFFLINE = 0;
    public static final int HON_STATUS_ONLINE = 3;
    public static final int HON_STATUS_INLOBBY = 4;
    public static final int HON_STATUS_INGAME = 5;

    public static final int HON_FLAGS_PREPURCHASED                  = 0x40;
    public static final int HON_FLAGS_CHAT_NONE                     = 0x00;
    public static final int HON_FLAGS_CHAT_OFFICER                  = 0x01;
    public static final int HON_FLAGS_CHAT_LEADER                   = 0x02;
    public static final int HON_FLAGS_CHAT_ADMINISTRATOR            = 0x03;
    public static final int HON_FLAGS_CHAT_STAFF                    = 0x04;

    // Client -> Server
    public static final int HON_CS_PONG                             = 0x2A01;
    public static final int HON_CS_CHANNEL_MSG                      = 0x03;
    public static final int HON_CS_WHISPER                          = 0x08;
    public static final int HON_CS_AUTH_INFO                        = 0x0C00;
    public static final int HON_CS_BUDDY_ADD_NOTIFY                 = 0x0D;
    public static final int HON_CS_JOIN_GAME                        = 0x10;
    public static final int HON_CS_CLAN_MESSAGE                     = 0x13;
    public static final int HON_CS_PM                               = 0x1C;
    public static final int HON_CS_JOIN_CHANNEL                     = 0x1E;
    public static final int HON_CS_WHISPER_BUDDIES                  = 0x20;
    public static final int HON_CS_LEAVE_CHANNEL                    = 0x22;
    public static final int HON_CS_USER_INFO                        = 0x2A;
    public static final int HON_CS_UPDATE_TOPIC                     = 0x30;
    public static final int HON_CS_CHANNEL_KICK                     = 0x31;
    public static final int HON_CS_CHANNEL_BAN                      = 0x32;
    public static final int HON_CS_CHANNEL_UNBAN                    = 0x33;
    public static final int HON_CS_CHANNEL_SILENCE_USER             = 0x38;
    public static final int HON_CS_GLOBAL_MESSAGE                   = 0x39;
    public static final int HON_CS_CHANNEL_PROMOTE                  = 0x3A;
    public static final int HON_CS_CHANNEL_DEMOTE                   = 0x3B;
    public static final int HON_CS_CHANNEL_AUTH_ENABLE              = 0x3E;
    public static final int HON_CS_CHANNEL_AUTH_DISABLE             = 0x3F;
    public static final int HON_CS_CHANNEL_AUTH_ADD                 = 0x40;
    public static final int HON_CS_CHANNEL_AUTH_DELETE              = 0x41;
    public static final int HON_CS_CHANNEL_AUTH_LIST                = 0x42;
    public static final int HON_CS_CHANNEL_SET_PASSWORD             = 0x43;
    public static final int HON_CS_JOIN_CHANNEL_PASSWORD            = 0x46;
    public static final int HON_CS_CLAN_ADD_MEMBER                  = 0x47;
    public static final int HON_CS_CLAN_REMOVE_MEMBER               = 0x17;
    public static final int HON_CS_CHANNEL_EMOTE                    = 0x65;
    public static final int HON_CS_BUDDY_ACCEPT                     = 0xB3;
    public static final int HON_CS_START_MM_GROUP                   = 0x0C0A;
    public static final int HON_CS_INVITE_TO_MM                     = 0x0C0D;
    public static final int HON_CS_KICK_FROM_MM                     = 0x0D00;

    // Server -> Client
    public static final int HON_SC_AUTH_ACCEPTED                    = 0x1C00;
    public static final int HON_SC_PING                             = 0x2A00;
    public static final int HON_SC_CHANNEL_MSG                      = 0x03;
    public static final int HON_SC_CHANGED_CHANNEL                  = 0x04;
    public static final int HON_SC_JOINED_CHANNEL                   = 0x05;
    public static final int HON_SC_LEFT_CHANNEL                     = 0x06;
    public static final int HON_SC_WHISPER                          = 0x08;
    public static final int HON_SC_WHISPER_FAILED                   = 0x09;
    public static final int HON_SC_INITIAL_STATUS                   = 0x0B;
    public static final int HON_SC_UPDATE_STATUS                    = 0x0C;
    public static final int HON_SC_CLAN_MESSAGE                     = 0x13;
    public static final int HON_SC_LOOKING_FOR_CLAN                 = 0x18;
    public static final int HON_SC_PM                               = 0x1C;
    public static final int HON_SC_PM_FAILED                        = 0x1D;
    public static final int HON_SC_WHISPER_BUDDIES                  = 0x20;
    public static final int HON_SC_MAX_CHANNELS                     = 0x21;
    public static final int HON_SC_USER_INFO_NO_EXIST               = 0x2B;
    public static final int HON_SC_USER_INFO_OFFLINE                = 0x2C;
    public static final int HON_SC_USER_INFO_ONLINE                 = 0x2D;
    public static final int HON_SC_USER_INFO_IN_GAME                = 0x2E; 
    public static final int HON_SC_CHANNEL_UPDATE                   = 0x2F; 
    public static final int HON_SC_UPDATE_TOPIC                     = 0x30;
    public static final int HON_SC_CHANNEL_KICK                     = 0x31;
    public static final int HON_SC_CHANNEL_BAN                      = 0x32;
    public static final int HON_SC_CHANNEL_UNBAN                    = 0x33;
    public static final int HON_SC_CHANNEL_BANNED                   = 0x34;
    public static final int HON_SC_CHANNEL_SILENCED                 = 0x35;
    public static final int HON_SC_CHANNEL_SILENCE_LIFTED           = 0x36;
    public static final int HON_SC_CHANNEL_SILENCE_PLACED           = 0x37;
    public static final int HON_SC_GLOBAL_MESSAGE                   = 0x39;
    public static final int HON_SC_CHANNEL_PROMOTE                  = 0x3A;
    public static final int HON_SC_CHANNEL_DEMOTE                   = 0x3B;
    public static final int HON_SC_CHANNEL_AUTH_ENABLE              = 0x3E;
    public static final int HON_SC_CHANNEL_AUTH_DISABLE             = 0x3F;
    public static final int HON_SC_CHANNEL_AUTH_ADD                 = 0x40;
    public static final int HON_SC_CHANNEL_AUTH_DELETE              = 0x41;
    public static final int HON_SC_CHANNEL_AUTH_LIST                = 0x42;
    public static final int HON_SC_CHANNEL_PASSWORD_CHANGED         = 0x43;
    public static final int HON_SC_CHANNEL_ADD_AUTH_FAIL            = 0x44;
    public static final int HON_SC_CHANNEL_DEL_AUTH_FAIL            = 0x45;
    public static final int HON_SC_JOIN_CHANNEL_PASSWORD            = 0x46;
    public static final int HON_SC_CLAN_MEMBER_ADDED                = 0x4E;
    public static final int HON_SC_CLAN_MEMBER_CHANGE               = 0x50;
    public static final int HON_SC_NAME_CHANGE                      = 0x5A;
    public static final int HON_SC_CHANNEL_ROLL                     = 0x64;
    public static final int HON_SC_CHANNEL_EMOTE                    = 0x65;
    public static final int HON_SC_TOTAL_ONLINE                     = 0x68;
    public static final int HON_SC_REQUEST_NOTIFICATION             = 0xB2;
    public static final int HON_SC_NOTIFICATION                     = 0xB4;
    public static final int HON_SC_TMM_GROUP_JOIN                   = 0x0C0E;
    public static final int HON_SC_TMM_GROUP_CHANGE                 = 0x0D03;
}