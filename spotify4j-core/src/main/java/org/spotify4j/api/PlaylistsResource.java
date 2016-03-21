package org.spotify4j.api;

import org.spotify4j.models.Page;
import org.spotify4j.models.PlaylistSimple;

public interface PlaylistsResource {

    Page<PlaylistSimple> getUserPlaylists(String userId);
//        return get("/v1/users/" + userId + "/playlists", new TypeReference<Page<PlaylistSimple>>() {
//        });
//    }
//
//    public static final String AccessToken = "BQBkoc4Ruilhrt6tyMC8uppK5lOcgpiuOGFaqdZff5U5RsX2755al8Y1JJYRPE9K_R6qjLh-tgE8FWmOifkxIjZf6q9nbrPWPq-4DJQhN6u4eefV_8a0iO-1NXuNfWqy_t2X6acQ75dWJpQuTIX2VPkzpYUUAR5J51zDW-jJPUETSKiPuH3PoYeCdm9CsTCUjWolmJYrkp0lJ6gfIPo4m6_UoSteuDuXbkKfuorh5PtfJNZ1rWQ9Tcw4PBmRvVCLlYfyPCvQS1RVZzSvSVhx3YwnnqZYGhz-2AsMUNuJcs5p";
//
//    public static void main(String[] args) throws IOException {
//        Page<PlaylistSimple> out = new PlaylistsResource().withAccessToken(AccessToken)
//        System.out.println(out);
//    }
}
