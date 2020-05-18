import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            IniFileReader ifr = new IniFileReader(new FileInputStream("goglog.ini"));
            String str = ifr.readIni("[1963513391]", "Dirs");
            System.out.println(str);
            IniFileWriter ifw = new IniFileWriter(new FileOutputStream("goglog.ini"));
            String[] key_value = {"ValueType_0", ""};
            ifw.writeIni("[1963513391]", key_value, new File("goglog.ini"));
        } catch (IOException | NoSuchFieldException e) {
            System.out.println("Не удалось изменить/прочитать");
        }
    }
}
