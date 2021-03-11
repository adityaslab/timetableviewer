package ttviewer.reader;

public class ClassInfo {
    private int time;
    private String sub;
    private String teacher;
    private String venue;
    private String link;
    private String classcode;
    public ClassInfo(int i, String[] a){
        time=i;
        classcode=a[0];
        teacher=a[2];
        venue=a[3];

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
