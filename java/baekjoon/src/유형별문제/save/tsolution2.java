package 유형별문제.save;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class tsolution2 {

    // 1. 유저마다 가지고 있는 돈 / 2. 1번째 있는 idx -> 2번쨰 있는 idx -> 3번 만큼 송금 / 3.
    public int[] solution(int[] balance, int[][] transactions, int[] abnormal) {
        int[] answer = new int[balance.length];

        HashMap<Integer, User> userMap = new HashMap<>();

        for (int i = 1; i <= balance.length; i++) {
            userMap.put(i, new User(i, balance[i - 1]));
        }

        for (int[] transaction : transactions) {
            int sendUserIdx = transaction[0];
            int receiveUserIdx = transaction[1];
            int sendAmount = transaction[2];

            // 1. 전송 데이터를 가져온다.
            LinkedList sendDataList = userMap.get(sendUserIdx).getSendDataList(sendAmount);

            // 2. 받는 유저 처리
            userMap.get(receiveUserIdx).receive(sendDataList);
        }

        for(int i=0; i<balance.length; i++){
            User user = userMap.get(i+1);
            user.delete(abnormal);

            answer[i] = user.amount;
        }

        return answer;
    }

    static class User {
        int amount;
        LinkedList<Data> dataList; //

        User(int idx, int amount) {
            this.amount = amount;
            dataList = new LinkedList<>();

            dataList.add(new Data(idx, amount));
        }

        void receive(LinkedList<Data> receives) {
            for (Data receive : receives) {
                dataList.add(receive);
                this.amount += receive.amount;
            }
        }

        LinkedList<Data> getSendDataList(int sendAmount) {
            LinkedList list = new LinkedList();

            int calcAmount = 0;
            while (calcAmount != sendAmount) {
                if (dataList.size() == 0) break;

                Data cur = dataList.getLast();

                // 뽑은 값이 더 커서 남겨야 할 경우 예외처리
                if (calcAmount + cur.amount > sendAmount) {
                    Data isAddData = new Data(cur.idx, sendAmount - calcAmount);
                    list.add(isAddData);
                    calcAmount += isAddData.amount;

                    // receiveList 처리
                    Data tmp = new Data(cur.idx, cur.amount - isAddData.amount);
                    dataList.removeLast();
                    dataList.add(tmp);
                    break;
                }

                list.add(cur);
                calcAmount += cur.amount;
                dataList.removeLast();
            }

            this.amount -= calcAmount;

            return list;
        }

        void delete(int[] abnormalList) {
            LinkedList<Data> saveList = new LinkedList();

            int calcAmount = 0;
            for(Data data : dataList) {
                boolean flag = true;
                for(int index : abnormalList) {
                    if(data.idx == index){
                        flag = false;
                        calcAmount += data.amount;
                        break;
                    }
                }

                if(!flag) continue;

                saveList.add(data);
            }

            this.amount -= calcAmount;
            dataList = saveList;
        }
    }

    static class Data {
        int idx, amount;

        Data(int idx, int amount) {
            this.idx = idx;
            this.amount = amount;
        }
    }

    public static void main(String[] args) {
        tsolution2 a = new tsolution2();
        int[] result = (a.solution(new int[]{30, 30, 30, 30},
                new int[][]{{1, 2, 10}, {2, 3, 20}, {3, 4, 5}, {3, 4, 30}},
                new int[]{1}
        ));

        for(int item : result){
            System.out.print(item + " ");
        }

    }
}
