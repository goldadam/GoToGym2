package GoToGym;
import GoToGym.IOMethod.IoView;
import GoToGym.recommend.recommendExercise;

import java.util.Scanner;
import java.sql.Date;

public class mainProgram {
    private static final int INDEXNUM_DISPLAY = 1;
    private static final int LENGTH_OF_EXERCISE = 9; //맨몸이나 weight나 둘다 운동종류 9개.
    private static final int DEFAULT_INT = 0;
    private static final double DEFAULT_DOUBLE = 0.0;
    private static final long miliseconds = System.currentTimeMillis();
    private static final int ERROR_DETECTOR = 0; //에러 찾아서 넣고 돌리기.
    private static IoView io = new IoView();
    static DbAccess dbAccess = new DbAccess();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Date date = new Date(miliseconds);
        io.output("현재 날짜는 " + date + " 입니다. ");
        io.output("즐거운 운동 되세요!");
        String Name;
        String gender;
        io.output("운동 프로그램에 오신 것을 환영합니다. ");
        io.output("이름을 입력해주세요");
        Name = sc.nextLine();
        io.output("성별을 입력해주세요");
        gender = sc.nextLine();
        gender = gender.trim(); //한글 입력시 공백제거
        if (!(gender.equals("남자") || gender.equals("여자") || gender.equals("male") || gender.equals("female"))) {
            io.output("잘못된 성별을 입력하셨습니다.");
            io.output("시스템이 종료됩니다. 다시 실행해주세요.");
            return;
        }
        io.output("원하시는 번호를 선택해주세요.");
        Workout workout = new Workout(Name, gender);
        io.output(Name + " " + "(" + gender + ") 님 환영합니다.");
        loop(workout);
    }

    public static void loop(Workout workout) {

        Scanner sc = new Scanner(System.in);
        int checkNum = 0;
        while (true) {
            // 케이스의 종류에 따라 운동 종류 분류하기...
            io.output("1번에서 7번까지 선택해주세요");
            io.output("1. 맨몸운동 추가하기");
            io.output("2. 중량운동 추가하기");
            io.output("3. 운동을 제거합니다.");
            io.output("4. 전체 운동 보기");
            io.output("5. 오늘의 운동 오마카세");
            io.output("6. 귀여운 고양이 보고가기");
            io.output("7. 프로그램 종료");
            checkNum = sc.nextInt();

            switch (checkNum) {
                case 1:
                    addExercise.addBodyExercise(workout);
                    break;
                case 2:
                    addExercise.addWeight(workout);
                    break;
                case 3:
                    removeMethod.removeExercise(workout);
                    break;
                case 4:
                    printMethod.printExercise(workout);
                    break;
                case 5:
                    recommendExercise.recommendExercises();
                    break;
                case 6:
                    printMethod.printCat();
                    break;
                case 7:
                    io.output("프로그램이 종료됩니다.");
                    System.exit(1);
                case 8:
                    io.output("시스템이 종료됩니다.");
                    System.exit(0); //정상적으로 시스템 종료함..

            }
        }
    }
}



