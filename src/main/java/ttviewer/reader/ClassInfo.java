package ttviewer.reader;

public class ClassInfo {
    private int time;
    private String sub;
    private String teacher;
    private String venue;
    private String link;
    private String classcode;
    public ClassInfo(int i, String[] a){
        this.time=i;
        this.classcode=a[0];
        this.teacher=a[2];
        this.venue=a[3];

    }
    public int getTime(Integer u){
        return this.time;
    }

    public String toStr(){
        return classcode+" \n"+teacher;
    }
    @Override
    public String toString() {
        return "ClassInfo{" +
                "time=" + time +
                ", sub='" + sub + '\'' +
                ", teacher='" + teacher + '\'' +
                ", venue='" + venue + '\'' +
                ", link='" + link + '\'' +
                ", classcode='" + classcode + '\'' +
                '}';
    }
}
