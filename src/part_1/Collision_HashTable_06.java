package part_1;

public class Collision_HashTable_06 {
    public Slot[] hashTable;

    public Collision_HashTable_06(Integer size) {
        this.hashTable = new Slot[size];
    }

    public class Slot {
        String value;
        Slot(String value) {
            this.value = value;
        }
    }

    /**
     * HashTable key에따른 index값 구하는 메소드
     * @param key : 검색할 key. 강의에서는 맨 앞자리 하나를 가지고 검색했다.
     * @return : key에 따른 인덱스 값
     */
    public int hashFunc(String key) {
        return (int)(key.charAt(0)) % this.hashTable.length;
    }

    /**
     * 데이터를 저장하기 위한 메소드
     * @param key : 저장 할 key
     * @param value : key에 따른 저장 할 value
     * @return
     */
    public boolean saveData(String key, String value) {
        Integer address = this.hashFunc(key); // 해당 key의 인덱스값 추출
        if (this.hashTable[address] != null) { // 검색된 key가 있다면
            this.hashTable[address].value = value; // @param value값으로 교체한다.
        } else { // 검색된 key값이 없다면
            this.hashTable[address] = new Slot(value); // 해당 값으로 마지막에 새로운 슬롯 생성 후 추가
        }
        return true;
    }

    /**
     * Hashtable key에 따른 value값 추출 메소드
     * @param key : key
     * @return : key에 따른 value값 추출
     */
    public String getData(String key) {
        Integer address = this.hashFunc(key); // key에 해당하는 인덱스 값 추출
        if (this.hashTable[address] != null) { // 해당 값이 있다면
            return this.hashTable[address].value; // 해당 값의 value값을 반환
        } else { // 검색된게 없다면
            return null; // null 반환
        }
    }



    public static void main(String[] args) {
        String name = "DaveLee";
        name.charAt(0);
        Slot[] hashTable = new Slot[20];
        // 주소를 저장하는 공간을 할당만 해서 null로 나온다.
        System.out.println(hashTable[0]);
//        hashTable[0] = new Slot("value"); // 슬롯에 아이템을 넣어 주소값을 할당시킨다.

        Collision_HashTable_06 hash = new Collision_HashTable_06(20);
        hash.saveData("daveLee","010");
        hash.saveData("fun-coding","011");
        System.out.println(hash.getData("daveLee"));

        System.out.println("+========================================+");

        Collision_HashTable_06 hashCollision = new Collision_HashTable_06(20);
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
