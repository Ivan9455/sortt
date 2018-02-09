

public class Sorts {
    public int[] sortIA(int[] x){
//      По очереди будем просматривать все подмножества
//      элементов массива (0 - последний, 1-последний,
//      2-последний,...)
        for (int i = 0; i < x.length; i++) {
//            Предполагаем, что первый элемент (в каждом
//            подмножестве элементов) является минимальным
            int min = x[i];
            int min_i = i;
//            В оставшейся части подмножества ищем элемент,
//            который меньше предположенного минимума
            for (int j = i + 1; j < x.length; j++) {
                //Если находим, запоминаем его индекс
                if (x[j] < min) {
                    min = x[j];
                    min_i = j;
                }
            }
//        Если нашелся элемент, меньший, чем на текущей позиции,
//          меняем их местами
            if (i != min_i) {
                int tmp = x[i];
                x[i] = x[min_i];
                x[min_i] = tmp;
            }
        }
        return x;
    }

    public int[] sortIB(int[] x){
        for (int i = 0; i < x.length; i++) {
            int min = x[i];
            int max_i = i;
            for (int j = i + 1; j < x.length; j++) {
                if (x[j] > min) {
                    min = x[j];
                    max_i = j;
                }
            }
            if (i != max_i) {
                int tmp = x[i];
                x[i] = x[max_i];
                x[max_i] = tmp;
            }
        }
        return x;
    }

    public String[] sortSA(String[] x){
        for (int i = 0; i < x.length; i++) {
            String min = x[i];
            int min_i = i;
            for (int j = i + 1; j < x.length; j++) {
                if (x[j].compareTo(min)<0) {
                    min = x[j];
                    min_i = j;
                }
            }
            if (i != min_i) {
                String tmp = x[i];
                x[i] = x[min_i];
                x[min_i] = tmp;
            }
        }
        return x;
    }

    public String[] sortSB(String[] x){
        for (int i = 0; i < x.length; i++) {
            String max = x[i];
            int max_i = i;
            for (int j = i + 1; j < x.length; j++) {
                if (x[j].compareTo(max)>0) {
                    max = x[j];
                    max_i = j;
                }
            }
            if (i != max_i) {
                String tmp = x[i];
                x[i] = x[max_i];
                x[max_i] = tmp;
            }
        }
        return x;
    }

}
