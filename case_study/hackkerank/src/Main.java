import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] arr = {73,67,38,33};
        List<Integer> list = new ArrayList<>();
        for (int in: arr
             ) {
            list.add(in);
        }
        System.out.println(gradingStudents(list));
    }

    public static List<Integer> gradingStudents(List<Integer> grades) {
        // Write your code here
        List<Integer> list = new ArrayList<>();
        int count = 0;
        for (Integer in: grades
             ) {
           if(in >= 38) {
                if(in%5!=0){
                    for (int i = 1; i < 3; i++) {
                        if(in%5==0){
                            if(count >= 3){
                                list.add(in-count);
                                count = 0;
                                break;
                            }else {
                                list.add(in);
                                count = 0;
                                break;
                            }
                        }
                        count++;
                        in++;
                    }
                }
            }else {
               list.add(in);
           }
        }
        return list;
    }
}