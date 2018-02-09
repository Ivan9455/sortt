import java.io.*;

public class Err {
    public String error = "";

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error += error;
    }

    public boolean errFile(String fileName) {
        try {
            BufferedReader buf = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8"));
        } catch (UnsupportedEncodingException | FileNotFoundException e) {
            //e.printStackTrace();
            setError("Файл " + fileName + " не найден!\n");
            return false;
        }


        return true;
    }

    public boolean errArgs(int i) {
        if (i == 4) {

        } else {
            setError("Не верно количесво аргументов!\n");
            return false;
        }
        return true;
    }

    public boolean typeFile(String fileName, String[] text, int line, String typeFile) {
        try {
            String str;
            BufferedReader buf = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8"));
            while ((str = buf.readLine()) != null) {
                text[line] = str;
                line++;
            }
            switch (typeFile) {
                case "-i":
                    try {
                        int[] textI = new int[line];
                        for (int i = 0; i < textI.length; i++) {
                            textI[i] = Integer.parseInt(text[i]);
                        }
                    } catch (Exception e) {
                        setError("Тип данных в файле указан не верно(-i)!\n");
                    }
                    break;
                case "-s":
                    try {
                        String[] textS = new String[line];
                        for (int i = 0; i < textS.length; i++) {
                            textS[i] = String.valueOf(text[i]);
                        }
                    } catch (Exception e) {
                        setError("Тип данных в файле указан не верно(-s)!\n");
                    }
                    break;
                default:
                    setError("Тип данных в файле указан не верно(" + typeFile + ")!\n");
                    break;
            }


        } catch (IOException e) {
            //e.printStackTrace();
            setError("Ошибка чтения файла!\n");
            return false;
        }
        return true;
    }

    public boolean errFiles(String file1, String file2) {
        return file1.equals(file2);
    }

    public boolean typeSort(String type) {
        switch (type) {
            case "-a":
                return true;
            case "-d":
                return  true;
            default:
                setError("Тип данных указан не верно(" + type + ")!\n");
                return  false;
        }
    }

//    public Err(String[] args){
//        this.errArgs(args.length);
//        this.errFiles(args[0],args[1]);
//
//    }

    public Err(){

    }
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
