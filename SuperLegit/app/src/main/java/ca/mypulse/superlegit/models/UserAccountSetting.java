package ca.mypulse.superlegit.models;

public class UserAccountSetting {

    private String birthday;
    private String education;
    private long event_attended;
    private long event_attending;
    private long follower;
    private String job;
    private String name;
    private String profile_photo;

    public UserAccountSetting() {

    }

    public UserAccountSetting(String birthday, String education, long event_attended, long event_attending, long follower, String job, String name, String profile_photo) {
        this.birthday = birthday;
        this.education = education;
        this.event_attended = event_attended;
        this.event_attending = event_attending;
        this.follower = follower;
        this.job = job;
        this.name = name;
        this.profile_photo = profile_photo;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public long getEvent_attended() {
        return event_attended;
    }

    public void setEvent_attended(long event_attended) {
        this.event_attended = event_attended;
    }

    public long getEvent_attending() {
        return event_attending;
    }

    public void setEvent_attending(long event_attending) {
        this.event_attending = event_attending;
    }

    public long getFollower() {
        return follower;
    }

    public void setFollower(long follower) {
        this.follower = follower;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfile_photo() {
        return profile_photo;
    }

    public void setProfile_photo(String profile_photo) {
        this.profile_photo = profile_photo;
    }

    @Override
    public String toString() {
        return "UserAccountSetting{" +
                "birthday='" + birthday + '\'' +
                ", education='" + education + '\'' +
                ", event_attended=" + event_attended +
                ", event_attending=" + event_attending +
                ", follower=" + follower +
                ", job='" + job + '\'' +
                ", name='" + name + '\'' +
                ", profile_photo='" + profile_photo + '\'' +
                '}';
    }
}
