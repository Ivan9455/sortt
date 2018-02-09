import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.*;


public class Main {
    private static int line = 0;


    public static void main(String[] args) throws IOException {

        String pathin = "./file/";
        String path = "./";
        String[] arr = {path + "in.txt", path + "out.txt", "-i", "-d"};
        BufferedReader buf = null;
        BufferedReader buf2 = null;
        Sorts sorts = new Sorts();
        String[] text = new String[200];
        String str;
        Err err = new Err();
        err.errArgs(arr.length);//количество аргументов
        err.errFile(arr[0]); //существует файл 1
        err.typeFile(arr[0], text, line, arr[2]); //тип читаемого файла(можно ли преобразовать)
        err.typeSort(arr[3]);//тип сортировки
        if (err.getError().equals("")) {
            if (err.errFiles(arr[0], arr[1])) err.setError("Внимание файл " + arr[0] + " будет перезаписан!");
            try {
                buf = new BufferedReader(new InputStreamReader(new FileInputStream(arr[0]), "UTF-8"));
                buf2 = new BufferedReader(new InputStreamReader(new FileInputStream(arr[1]), "UTF-8"));
            }catch (Exception e){

            }


            while ((str = buf.readLine()) != null) {
                text[line] = str;
                line++;
            }

            switch (arr[2]) {
                case "-i":
                    int[] textI = new int[line];
                    for (int i = 0; i < textI.length; i++) {
                        textI[i] = Integer.parseInt(text[i]);
                    }
                    switch (arr[3]) {
                        case "-a":
                            try {
                                FileWriter newFile = new FileWriter(arr[1]);
                                textI = sorts.sortIA(textI);
                                for (int i = 0; i < textI.length; i++) {
                                    newFile.write(String.valueOf(textI[i]) + "\r\n");
                                }
                                newFile.flush();
                                newFile.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                                break;
                            }
                            break;
                        case "-d":
                            try {
                                FileWriter newFile = new FileWriter(arr[1]);
                                textI = sorts.sortIB(textI);
                                for (int i = 0; i < textI.length; i++) {
                                    newFile.write(String.valueOf(textI[i]) + "\r\n");
                                }
                                newFile.flush();
                                newFile.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                                break;
                            }
                            break;
                        default:
                            err.setError("Указан не верный тип сортировки!\n") ;
                            break;
                    }
                    break;
                case "-s":
                    String[] textS = new String[line];
                    for (int i = 0; i < textS.length; i++) {
                        textS[i] = text[i];
                    }
                    switch (arr[3]) {
                        case "-a":
                            try {
                                FileWriter newFile = new FileWriter(arr[1]);
                                textS = sorts.sortSA(textS);
                                for (int i = 0; i < textS.length; i++) {
                                    newFile.write(String.valueOf(textS[i]) + "\r\n");
                                }
                                newFile.flush();
                                newFile.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                                break;
                            }
                            break;
                        case "-d":
                            try {
                                FileWriter newFile = new FileWriter(arr[1]);
                                textS = sorts.sortSB(textS);
                                for (int i = 0; i < textS.length; i++) {
                                    newFile.write(String.valueOf(textS[i]) + "\r\n");
                                }
                                newFile.flush();
                                newFile.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                                break;
                            }
                            break;
                        default:
                            err.setError("указан не верный тип сортировки\n");
                            break;
                    }
                    break;
                default:
                    err.setError("указан не верный тип данных\n");
                    break;
            }
        }
        else{
            err.setError("Операция была прервана!\n");
        }
        System.out.println(err.getError());
    }


}
