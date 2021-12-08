package GoToGym;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
//유산소 운동 및 맨몸운동 만드는 Exercise 클래스, 중량운동은 이 클래스 상속받아서 Weight 변수만 추가해서 다시 만드는 식으로 진행.
import java.util.*;
import java.io.*;
@AllArgsConstructor
@Setter
@ToString
@Getter
//맨몸운동 설명하는 클래스.
public class Exercise {
    private String name;
    private String explanation;
    private int sets;
    private int reps;


    @Override
    public String toString() {
        return this.getName() + "  sets:  " + this.getSets() + "   reps: " + this.getSets() + this.getExplanation();
    }


}
