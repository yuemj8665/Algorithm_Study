package jupyter;

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
     *
     * @param key
     * @param value
     * @return
     */
    public boolean saveData(String key, String value){
        Integer address = this.hashFunc(key); // 키를 기반으로 주소를 검색한다.
        if(this.hashTable[address] != null) { // 주소 검색하여 슬롯에 있을 떄
            if (this.hashTable[address].key == key) {
                this.hashTable[address].value = value;
                return true;
            } else {
                Integer currAddress = address +1;
                while (this.hashTable[currAddress] != null) {
                    if (this.hashTable[currAddress].key == key) {
                        this.hashTable[currAddress].value = value;
                        return true;
                    } else {
                        currAddress++;
                        if (currAddress >= this.hashTable.length) {
                            return false;
                        }
                    }
                }
                this.hashTable[currAddress] = new Slot(key, value);
                return true;
            }
        } else {
            this.hashTable[address] = new Slot(key,value);
        }

        return true;
    }

    public String getData(String key) {
        Integer address = this.hashFunc(key);
        if (this.hashTable[address] != null) {
            if (this.hashTable[address].key == key) {
                return this.hashTable[address].value;
            } else {
                Integer currAddress = address+1;
                while (this.hashTable[currAddress] != null) {
                    if (this.hashTable[currAddress].key == key) {
                        return this.hashTable[currAddress].value;
                    } else {
                        currAddress++;
                        if (currAddress >= this.hashTable.length) {
                            return null;
                        }
                    }
                }
                return null;
            }
        } else {
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
