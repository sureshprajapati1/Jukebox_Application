package DAOInterfaces;

import Model.Podcast;

import java.util.List;

public interface PodcastInterface {
    public List<Podcast> displayAllPodcast();
    public List<Podcast> sortPodcast();
    public Podcast searchPodcast(String podcast_name);
}
