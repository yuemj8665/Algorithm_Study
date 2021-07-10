package part_1;

/**
 * HashTable의 충돌(Collsion)을 방지하기 위한 Close Hasing 기법
 *
 */
public class Close_HashTable_06 {
    public Slot[] hashTable;
    public Close_HashTable_06(Integer size){
        this.hashTable = new Slot[size]; // 배열의 사이즈를 미리 할당 할 수 있도록 구성
    }

    /**
     * 특정 슬롯을 추가를 했을 떄, 반드시 해당 슬롯에 키에 해당되는 데이터가 저장 되어있을 보장이 없다.
     * 해당 데이터가 키에 해당되는 데이터인지 확인해야한다.
     */
    public static class Slot{
        String key;
        String value;
        Slot(String key, String value){ // 생성자
            this.key = key;
            this.value = value;
        }
    }

    public Integer hashFunc(String key){
        return (int)(key.charAt(0)) % this.hashTable.length;
    }

    /**
     * hashTable 데이터 추가 메소드
     * @param key
     * @param value
     * @return
     */
    public boolean saveData(String key, String value){
        Integer address = this.hashFunc(key);  
        if(this.hashTable[address] != null) { // key의 인덱스를 찾았다면
            if (this.hashTable[address].key == key) { // 그 key가 맞다면
                this.hashTable[address].value = value; // key에 해당하는 value값 반환
                return true;
            } else { // 해당 key가 아니라면
                Integer currAddress = address +1; // 다음 인덱스로 
                while (this.hashTable[currAddress] != null) { // 다음 인덱스 탐색 시작
                    if (this.hashTable[currAddress].key == key) { // 다음 인덱스가 해당 key가 맞다면
                        this.hashTable[currAddress].value = value; // key에 해당하는 value값 반환
                        return true;
                    } else {
                        currAddress++; // 인덱스에 해당하는 key가 아니라면 다음 인덱스로 이동
                        if (currAddress >= this.hashTable.length) { // 다음 인덱스로 이동햇을때 hashTable의 최대 길이를 넘었다면
                            return false; // 더이상 검색 할 위치가 없음으로 실패 반환
                        }
                    }
                }
                // 다음 인덱스 탐색이 종료된 후 + hashTable의 최대길이에 도달하지 않았을 때
                this.hashTable[currAddress] = new Slot(key, value); // 해당 인덱스에 새로운 슬롯을 생성하여 추가한다.
                return true;
            }
        } else { // key의 인덱스를 못 찾았다면
            this.hashTable[address] = new Slot(key,value); // 해당 인덱스에 새로운 슬롯을 생성하여 추가한다.
        }
        return true;
    }

    /**
     * hashTable key에 해당하는 value값 검색하는 메소드
     * @param key
     * @return
     */
    public String getData(String key) {
        Integer address = this.hashFunc(key);
        if (this.hashTable[address] != null) { // key에 해당하는 인덱스를 찾음
            if (this.hashTable[address].key == key) { // 해당 key가 검색하려는 key라면
                return this.hashTable[address].value; // key에 해당하는 value값을 리턴
            } else { // key에 해당하는 인덱스를 못찾았다면
                Integer currAddress = address+1; // 다음 인덱스로 이동
                while (this.hashTable[currAddress] != null) { // 다음 인덱스값이 존재한다면
                    if (this.hashTable[currAddress].key == key) { // 해당 인덱스의 key값과 비교
                        return this.hashTable[currAddress].value; // key에 해당하는 value값 리턴
                    } else {
                        currAddress++; // 인덱스에 해당하는 key가 아니라면 다음 인덱스로 이동
                        if (currAddress >= this.hashTable.length) { // 다음 인덱스로 이동햇을때 hashTable의 최대 길이를 넘었다면
                            return null; // 더이상 검색 할 위치가 없음으로 null 반환
                        }
                    }
                }
                // 한 바퀴를 돌았음에도 못찾았으면
                return null; // null 반환
            }
        } else { // 인덱스를 못찾았다면
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

        Close_HashTable_06 hash = new Close_HashTable_06(20);
        hash.saveData("daveLee","010");
        hash.saveData("fun-coding","011");
        System.out.println(hash.getData("daveLee"));

        System.out.println("+========================================+");

        Close_HashTable_06 cloas_hashTable = new Close_HashTable_06(20);
        cloas_hashTable.saveData("daveLee","1");
        cloas_hashTable.saveData("daveLee","2");
        cloas_hashTable.saveData("daveLee","3");
        cloas_hashTable.saveData("fun-coding","5");
        cloas_hashTable.saveData("david","2");
        cloas_hashTable.saveData("dave","888888");

        /**
         * 기존에 구현한 해쉬 테이블의 문제점
         * 1. 기존에 구현했던 해쉬 테이블은 key값의 맨 앞자리부분을 사용하여 데이터를 저장한다.
         * 2. 그렇게되어 D로 시작하는 놈들은 가장 마지막에 저장된 dave의 value값이 저장된다.
         * 여러가지 키가 있을 떄 이러한 경우를 충돌이라 부른다.
         *
         */
        System.out.println(cloas_hashTable.getData("daveLee"));
        System.out.println(cloas_hashTable.getData("fun-coding"));
        System.out.println(cloas_hashTable.getData("david"));
        System.out.println(cloas_hashTable.getData("dave"));

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
