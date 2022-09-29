package sshukla.java.solid.lsp.example2;

/**
 * @author 'Seemant Shukla' on '25/09/2022'
 */

/**
 * Problem is we have 4 methods and at least one method is there which is not support by one of the social media platform.
 * so, we need to create interface or abstract class such that we have only those apis for that particular social media platform
 * and not the one which is not supported e.g. groupVideoCall() is not supported by Instagram so we dont need to have that
 * in out InstagramSocialMedia class
 **/

public abstract class SocialMedia {

    //@support WhatsApp,Facebook,Instagram
    public abstract void chatWithFriend();

    //@support Facebook,Instagram
    public abstract void publishPost(Object post);

    //@support WhatsApp,Facebook,Instagram
    public abstract void sendPhotosAndVideos();

    //@support WhatsApp,Facebook
    public abstract void groupVideoCall(String... users);
}
