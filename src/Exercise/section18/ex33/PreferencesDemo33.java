package Exercise.section18.ex33;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.prefs.Preferences;

public class PreferencesDemo33 {
    public static void main(String[] args) throws Exception{
        Preferences prefs =
                Preferences.userNodeForPackage(PreferencesDemo33.class);
        int value = prefs.getInt("base directory", 0);
        System.out.println("Base directory value="+value+
                "\nEnter new base directory value (integer)");
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );
        try {
            value = Integer.parseInt(br.readLine());
        } catch (Exception e) {
            System.err.println(e);
            System.exit(1);
        }
        prefs.putInt("base directory",value);
    }
}
