package pccp;
import java.util.*;

public class 실습용로봇 {

    class Solution {
        public int[] solution(String commands) {
            Rocket rocket = new Rocket();

            for(char command : commands.toCharArray()){
                rocket.run(command);
            }

            return new int[]{rocket.getX(), rocket.getY()};
        }

        class Rocket{
            // 초기 값 설정
            int x = 0, y = 0, direction = 3;
            // 동, 남, 서, 북
            int dx[] = {1, 0, -1, 0};
            int dy[] = {0, -1, 0, 1};

            void rotate(char rotate) {
                if(rotate == 'R') {
                    this.direction += 1;
                }else {
                    this.direction -= 1;
                }

                this.direction = this.direction < 0 ? 3 : this.direction > 3 ? 0 : this.direction;
            }

            void move(char command) {
                if(command == 'G') {
                    this.x += this.dx[this.direction];
                    this.y += this.dy[this.direction];
                }
                else {
                    this.x += this.dx[(this.direction + 2) % 4];
                    this.y += this.dy[(this.direction + 2) % 4];
                }
            }

            void run(char command) {
                if(command == 'R' || command == 'L') {
                    this.rotate(command);
                }else {
                    this.move(command);
                }
            }

            int getX() {
                return this.x;
            }

            int getY() {
                return this.y;
            }
        }
    }
}
