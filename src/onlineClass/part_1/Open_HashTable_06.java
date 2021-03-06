package part_1;

/**
 * HashTable의 충돌(Collsion)을 방지하기 위한 Open Hasing 기법
 * Linked List 자료구조를 활용한다.
 */
public class Open_HashTable_06 {
    public Slot[] hashTable;
    public Open_HashTable_06(Integer size){
        this.hashTable = new Slot[size]; // 배열의 사이즈를 미리 할당 할 수 있도록 구성
    }

    public static class Slot{
        String key;
        String value;
        // LinkedList를 활용하기 위해 포인터를 next로 옮길 수 있는 next 변수를 추가한다.
        Slot next;
        Slot(String key, String value){ // 생성자
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public Integer hashFunc(String key){
        return (int)(key.charAt(0)) % this.hashTable.length;
    }

    /**
     * LinkedList를 활용하여 데이터를 추가한다.
     * @param key
     * @param value
     * @return
     */
    public boolean saveData(String key, String value){
        Integer address = this.hashFunc(key);
        if(this.hashTable[address]!= null){ // key를 찾았다면
            Slot findSlot = this.hashTable[address]; // 슬롯에 해당 테이블을 우선 할당
            Slot prevSlot = this.hashTable[address];
            while (findSlot != null) { // 슬롯 탐색
                if (findSlot.key == key) { // 검색 할 key를 가진 슬롯이 있다면
                    findSlot.value = value; // 해당 슬롯의 value값을 변경
                    return true; // 메소드 종료
                } else { // 검색 할 key를 가진 슬롯을 못찾았다면
                    prevSlot = findSlot; // 전 슬롯을 현재슬롯으로 전환,
                    findSlot = findSlot.next; // 현재 슬롯을 다음 슬롯으로 전환하여 다시 탐색 시작
                }
            }
            // while문이 끝나 테이블 한바퀴를 돌았음에도 찾지 못했다면
            prevSlot.next = new Slot(key, value); // 마지막 슬롯에 새로운 슬롯을 추가한다.
        }
        else{ // key를 못찾은 경우
            // 해당 테이블에 새로운 슬롯을 추가한다.
            this.hashTable[address] = new Slot(key,value);
        }
        return true;
    }

    /**
     * 입력한 key에 해당하는 HashTable 검색기능
     * @param key
     * @return
     */
    public String getData(String key){
        Integer address = this.hashFunc(key);
        if(this.hashTable[address]!=null){ // key의 인덱스를 찾았다면
            Slot findSlot = this.hashTable[address]; // 현재 슬롯에 검색한 key의 슬롯을 추가
            while (findSlot != null) { // 슬롯 탐색
                if (findSlot.key == key) { // 검색 할 key를 가진 슬롯이 있다면
                    return findSlot.value; // 해당 슬롯의 value를 반환한다.
                } else { // 검색 할 key를 가진 슬롯이 없다면
                    findSlot = findSlot.next; // 현재 슬롯을 다음슬롯으로 바꿔 다시 탐색 시작한다
                }
            } // 모든 탐색이 끝난 경우(못 찾은 경우)
            return null; // 메소드 종료
        }
        else{ // key의 인덱스를 아예 못 찾은 경우
            return null;
        }

    }



    public static void main(String[] args) {
        String name = "DaveLee";
        name.charAt(0);
        Slot[] hashTable = new Slot[20];
        // 주소를 저장하는 공간을 할당만 해서 null로 나온다.
        System.out.println(hashTable[0]);
//        hashTable[0] = new Slot("value"); // 슬롯에 아이템을 넣어 주소값을 할당시킨다.

        Open_HashTable_06 hash = new Open_HashTable_06(20);
        hash.saveData("daveLee","010");
        hash.saveData("fun-coding","011");
        System.out.println(hash.getData("daveLee"));

        System.out.println("+========================================+");

        Open_HashTable_06 hashCollision = new Open_HashTable_06(20);
        hashCollision.saveData("daveLee","1");
        hashCollision.saveData("daveLee","2");
        hashCollision.saveData("daveLee","3");
        hashCollision.saveData("fun-coding","5");
        hashCollision.saveData("david","2");
        hashCollision.saveData("dave","888888");

        /**
         * 기존에 구현한 해쉬 테이블의 문제점
         * 1. 기존에 구현했던 해쉬 테이블은 key값의 맨 앞자리부분을 사용하여 데이터를 저장한다.
         * 2. 그렇게되어 D로 시작하는 놈들은 가장 마지막에 저장된 dave의 value값이 저장된다.
         * 여러가지 키가 있을 떄 이러한 경우를 충돌이라 부른다.
         *
         */
        System.out.println(hashCollision.getData("daveLee"));
        System.out.println(hashCollision.getData("fun-coding"));
        System.out.println(hashCollision.getData("david"));
        System.out.println(hashCollision.getData("dave"));

        /**
         * 충돌 수정 전
         * 888888
         * 5
         * 888888
         * 888888
         */

        /**
         * 충돌 수정 후
         * 3
         * 5
         * 2
         * 888888
         */
    }
}
