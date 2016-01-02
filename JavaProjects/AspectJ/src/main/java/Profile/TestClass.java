package Profile;


public class TestClass {

    @Profiler
    public void test(){
        String str = "";
        for (int i = 0; i < 10000; i++) {
            str += "kkkk";
        }
    }
}
