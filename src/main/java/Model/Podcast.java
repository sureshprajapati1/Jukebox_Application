package Model;

public class Podcast {
    private String podcast_name;
    private int podcast_id;
    private String podcast_duration;
    private String podcast_episode;
    private String podcast_lang;
    private String podcast_file_path;
    private int p_id;
    public Podcast(){}

    public Podcast(String podcast_name, int podcast_id, String podcast_duration, String podcast_episode, String podcast_lang, String podcast_file_path, int p_id) {

        this.podcast_name = podcast_name;
        this.podcast_id = podcast_id;
        this.podcast_duration = podcast_duration;
        this.podcast_episode = podcast_episode;
        this.podcast_lang = podcast_lang;
        this.podcast_file_path = podcast_file_path;
        this.p_id = p_id;
    }

    public String getPodcast_name() {
        return podcast_name;
    }

    public void setPodcast_name(String podcast_name) {
        this.podcast_name = podcast_name;
    }

    public int getPodcast_id(int anInt) {
        return podcast_id;
    }

    public void setPodcast_id(int podcast_id) {
        this.podcast_id = podcast_id;
    }

    public String getPodcast_duration() {
        return podcast_duration;
    }

    public void setPodcast_duration(String podcast_duration) {
        this.podcast_duration = podcast_duration;
    }

    public String getPodcast_episode() {
        return podcast_episode;
    }

    public void setPodcast_episode(String podcast_episode) {
        this.podcast_episode = podcast_episode;
    }

    public String getPodcast_lang() {
        return podcast_lang;
    }

    public void setPodcast_lang(String podcast_lang) {
        this.podcast_lang = podcast_lang;
    }

    public String getPodcast_file_path() {
        return podcast_file_path;
    }

    public void setPodcast_file_path(String podcast_file_path) {
        this.podcast_file_path = podcast_file_path;
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    @Override
    public String toString() {
        return "Podcast{" +
                "podcast_name='" + podcast_name + '\'' +
                ", podcast_id=" + podcast_id +
                ", podcast_duration='" + podcast_duration + '\'' +
                ", podcast_episode='" + podcast_episode + '\'' +
                ", podcast_lang='" + podcast_lang + '\'' +
                ", podcast_file_path='" + podcast_file_path + '\'' +
                ", p_id=" + p_id +
                '}';
    }
}
