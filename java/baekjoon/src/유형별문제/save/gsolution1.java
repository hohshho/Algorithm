package 유형별문제.save;

import java.util.*;

public class gsolution1 {

    public int solution(int K, String[] user_scores) {
        int answer = 0;
        Ranking ranking = new Ranking(K);

        for(String user_score : user_scores) {
            ranking.addRanking(user_score);
        }

        return ranking.getResult();
    }

    static class Ranking {
        int K, min;
        int result = 0;
        LinkedList<User> q = new LinkedList<>();
        HashMap<String, Integer> UserMap = new HashMap<>();
        HashMap<Integer, String> rankingMap = new HashMap<>();

        Ranking(int K) {
            this.K = K;
        }

        void addRanking(String user_score) {
            String[] data = user_score.split(" ");
            String name = data[0];
            int score = Integer.parseInt(data[1]);

            User user = new User(score, name);
            // 초기 값
            if (result == 0) {
                min = score;
                result += 1;
                q.add(user);
                UserMap.put(user.name, user.score);
                rankingMap.put(0, user.name);
                return;
            }

            // 랭킹 리스트 만들어 졌을 때 최저 점수보다 작으면 pass
            if (q.size() == K && min >= score) {
                return;
            }

            // 유저의 최고 점수보다 낮은 경우 pass
            if (UserMap.containsKey(name)) {
                if (UserMap.get(name) >= score) {
                    return;
                }
            }

            min = Math.min(min, score);

            // 변경여부 비교하기 위해 복사
            LinkedList<User> prevQ = new LinkedList<>();
            for(int i=0; i < q.size(); i++){
                User cur = q.get(i);
                prevQ.add(new User(cur.score, cur.name));
            }

            // 랭킹에 있는 경우
            if (UserMap.containsKey(user.name)) {
                User curUser = null;
                int i;
                for (i = 0; i < q.size(); i++) {
                    curUser = q.get(i);
                    if(curUser.name.equals(user.name)){
                        break;
                    }
                }
                
                if(curUser.score >= user.score){
                    return;
                }

                // 랭킹에 있는 경우 기존에 저장하던 값 변경하기 위해 삭제
                q.remove(i);
                UserMap.remove(user.name);
            }

            q.add(user);
            UserMap.put(user.name, user.score);

            Collections.sort(q, new Comparator<User>() {
                @Override
                public int compare(User o1, User o2) {
                    return -(o1.score - o2.score);
                }
            });

            if(K < q.size()) {
                User removeUser = q.getLast();
                q.remove(q.size() - 1);
                UserMap.remove(removeUser.name);
            }

            // 이전 랭킹과 비교하여 변경 된 경우만 result + 1
            if(q.size() == prevQ.size()) {
                for(int i=0; i<q.size(); i++){
                    if(!q.get(i).name.equals(prevQ.get(i).name)) {
                        result += 1;
                        break;
                    }
                }
                return;
            }

            result += 1;
        }

        int getResult() {
            return result;
        }
    }

    static class User {
        int score;
        String name;

        User(int score, String name) {
            this.score = score;
            this.name = name;
        }
    }

    public static void main(String[] args) {
        gsolution1 a = new gsolution1();
//        System.out.println(a.solution(3, new String[]{"alex111 100", "cheries2 200", "coco 150", "luna 100", "alex111 120", "coco 300", "cheries2 110"}));
        System.out.println(a.solution(3, new String[]{"alex111 100", "cheries2 200", "alex111 200", "cheries2 150", "coco 50", "coco 200"}));
    }
}
