
import java.io.*;


public class Main {
    private static int line = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader buf = null;
        BufferedReader buf2 = null;
        Sorts sorts = new Sorts();
        String[] text = new String[200];
        String str;

        Err err = new Err();
        try {
            err.errArgs(args.length);//количество аргументов
            err.errFile(args[0]); //существует файл 1
            err.typeFile(args[0], text, line, args[2]); //тип читаемого файла(можно ли преобразовать)
            err.typeSort(args[3]);//тип сортировки
        }
        catch (Exception e){

        }
        if (err.getError().equals("")) {
            if (err.errFiles(args[0], args[1])) err.setError("Внимание файл " + args[0] + " будет перезаписан!");
            try {
                buf = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));
                buf2 = new BufferedReader(new InputStreamReader(new FileInputStream(args[1])));
            }catch (Exception e){

            }


            while ((str = buf.readLine()) != null) {
                text[line] = str;
                line++;
            }

            switch (args[2]) {
                case "-i":
                    int[] textI = new int[line];
                    for (int i = 0; i < textI.length; i++) {
                        textI[i] = Integer.parseInt(text[i]);
                    }
                    switch (args[3]) {
                        case "-a":
                            try {
                                FileWriter newFile = new FileWriter(args[1]);
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
                                FileWriter newFile = new FileWriter(args[1]);
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
                    switch (args[3]) {
                        case "-a":
                            try {
                                FileWriter newFile = new FileWriter(args[1]);
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
                                FileWriter newFile = new FileWriter(args[1]);
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
