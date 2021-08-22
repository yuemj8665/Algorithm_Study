package review.part_1;

public class HashTableReview {
    /**
     * 해쉬 테이블이란 key와 value값을 이용하여 데이터를 저정하는 기법
     */
    public Slot[] hashTable;

    public HashTableReview(int size) {
        this.hashTable = new Slot[size];
    }

    public class Slot {
        String value;

        Slot(String value) {
            this.value = value;
        }
    }

    /**
     * 만들어야 할것을 생각하기
     * 1. key에 따른 index 계산하는 메소드
     * 2. 데이터 저장을 위한 메소드
     * 3. hasgTable Key에 따른 value값 추출
     */

    /**
     * 1. key에 따른 index 계산하는 메소드
     * @param key
     * @return
     */
    public int hashFunc(String key) {
        return (int)(key.charAt(0)) % this.hashTable.length;
    }

    /**
     * 2. 데이터 저장을 위한 메소드
     * @param key
     * @param value
     * @return
     */
    public boolean saveData(String key, String value) {
        Integer address = this.hashFunc(key);
        if (this.hashTable[address] != null) {
            this.hashTable[address].value = value;
        } else {
            this.hashTable[address] = new Slot(value);
        }
        return true;
    }

    /**
     * 3. hasgTable Key에 따른 value값 추출
     * @param key
     * @return
     */
    public String getData(String key) {
        Integer address = this.hashFunc(key);
        if (this.hashTable[address] != null) {
            return this.hashTable[address].value;
        } else {
            return null;
        }
    }





    public static void main(String[] args) {
        Slot[] hashTable = new Slot[20];
        System.out.println(hashTable[0]);

        HashTableReview ht = new HashTableReview(20);
        String name1 = "MJ";
        ht.saveData(name1, "01048578665");
        System.out.printf("HashTableReview | 이름 : %s | 값 : %s \r\n",name1,ht.getData(name1));

        String name2 = "MP";
        ht.saveData(name2, "01099999999");
        System.out.printf("HashTableReview | 이름 : %s | 값 : %s \r\n",name2,ht.getData(name2));
        System.out.printf("HashTableReview | 이름 : %s | 값 : %s \r\n",name1,ht.getData(name1));

        String name3 = "HJ";
        ht.saveData(name3, "01088888888");
        System.out.printf("HashTableReview | 이름 : %s | 값 : %s \r\n",name3,ht.getData(name3));




    }
}

/**
 * 충돌을 방지하기 위한 해쉬 테이블
 * LinkedList 자료구조를 이용한다.
 */
class OpenHashTable {
    /**
     * 해쉬 테이블이란 key와 value값을 이용하여 데이터를 저정하는 기법
     */
    public Slot[] hashTable;

    public OpenHashTable(int size) {
        this.hashTable = new OpenHashTable.Slot[size];
    }

    public class Slot {
        String key;
        String value;
        Slot next;

        Slot(String key, String value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    /**
     * 만들어야 할것을 생각하기
     * 1. key에 따른 index 계산하는 메소드
     * 2. 데이터 저장을 위한 메소드
     * 3. hasgTable Key에 따른 value값 추출
     */

    /**
     * 1. key에 따른 index 계산하는 메소드
     * @param key
     * @return
     */
    public int hashFunc(String key) {
        return (int)(key.charAt(0)) % this.hashTable.length;
    }

    /**
     * 2. 데이터 저장을 위한 메소드
     * @param key
     * @param value
     * @return
     */
    public boolean saveData(String key, String value) {
        Integer address = this.hashFunc(key);
        if (this.hashTable[address] != null) {
            Slot findSlot = this.hashTable[address];
            Slot prevSlot = this.hashTable[address];
            while (findSlot != null) {
                if (findSlot.key == key) {
                    findSlot.value = value;
                    return true;
                } else {
                    prevSlot = findSlot;
                    findSlot = findSlot.next;
                }
            }
            prevSlot.next = new Slot(key, value);
        } else {
            this.hashTable[address] = new Slot(key,value);
        }
        return true;
    }

    /**
     * 3. hasgTable Key에 따른 value값 추출
     * @param key
     * @return
     */
    public String getData(String key) {
        Integer address = this.hashFunc(key);
        if (this.hashTable[address] != null) {
            Slot findSlot = this.hashTable[address];
            while (findSlot != null) {
                if (findSlot.key == key) {
                    return findSlot.value;
                } else {
                    findSlot = findSlot.next;
                }
            }
            return null;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        Slot[] hashTable = new Slot[20];
        System.out.println(hashTable[0]);

        OpenHashTable ht = new OpenHashTable(20);
        String name1 = "MJ";
        ht.saveData(name1, "01048578665");
        System.out.printf("OpenHashTable | 이름 : %s | 값 : %s \r\n",name1,ht.getData(name1));

        String name2 = "MP";
        ht.saveData(name2, "01099999999");
        System.out.printf("OpenHashTable | 이름 : %s | 값 : %s \r\n",name2,ht.getData(name2));
        System.out.printf("OpenHashTable | 이름 : %s | 값 : %s \r\n",name1,ht.getData(name1));

        String name3 = "HJ";
        ht.saveData(name3, "01088888888");
        System.out.printf("OpenHashTable | 이름 : %s | 값 : %s \r\n",name3,ht.getData(name3));
    }
}

/**
 * 충돌을 방지하기 위한 해쉬 테이블
 */
class CloseHashTable {
    /**
     * 해쉬 테이블이란 key와 value값을 이용하여 데이터를 저정하는 기법
     */
    public Slot[] hashTable;

    public CloseHashTable(int size) {
        this.hashTable = new Slot[size];
    }

    /**
     * 특정 슬롯을 추가 했을 때 반드시 해당 슬롯의 키에 해당되는 데이터가 저장되어있을 보장이 없다.
     * 해당 데이터가 키에 해당되는 데이터인지 먼저 확인해야한다.
     */
    public class Slot {
        String key;
        String value;

        Slot(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    /**
     * 만들어야 할것을 생각하기
     * 1. key에 따른 index 계산하는 메소드
     * 2. 데이터 저장을 위한 메소드
     * 3. hasgTable Key에 따른 value값 추출
     */

    /**
     * 1. key에 따른 index 계산하는 메소드
     * @param key
     * @return
     */
    public int hashFunc(String key) {
        return (int)(key.charAt(0)) % this.hashTable.length;
    }

    /**
     * 2. 데이터 저장을 위한 메소드
     * @param key
     * @param value
     * @return
     */
    public boolean saveData(String key, String value) {
        Integer address = this.hashFunc(key);
        if (this.hashTable[address] != null) {
            if (this.hashTable[address].key == key) {
                this.hashTable[address].value = value;
            } else {
                Integer currentAddress = address+1;
                while (this.hashTable[currentAddress] != null) {
                    if (this.hashTable[currentAddress].key == key) {
                        this.hashTable[currentAddress].value = value;
                        return true;
                    } else {
                        currentAddress++;
                        if (currentAddress >= this.hashTable.length) {
                            return false;
                        }
                    }
                }
                this.hashTable[currentAddress] = new Slot(key, value);
                return true;
            }
        } else {
           this.hashTable[address] = new Slot(key,value);
        }
        return true;
    }

    /**
     * 3. hasgTable Key에 따른 value값 추출
     * @param key
     * @return
     */
    public String getData(String key) {
        Integer address = this.hashFunc(key);
        if (this.hashTable[address] != null) {
            if (this.hashTable[address].key == key) {
                return this.hashTable[address].value;
            } else {
                Integer currentAddress = address + 1;
                while (this.hashTable[currentAddress] != null) {
                    if (this.hashTable[currentAddress].key == key) {
                        return this.hashTable[currentAddress].value;
                    } else {
                        currentAddress++;
                        if (currentAddress >= this.hashTable.length) {
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
        Slot[] hashTable = new Slot[20];
        System.out.println(hashTable[0]);

        CloseHashTable ht = new CloseHashTable(20);
        String name1 = "MJ";
        ht.saveData(name1, "01048578665");
        System.out.printf("CloseHashTable | 이름 : %s | 값 : %s \r\n",name1,ht.getData(name1));

        String name2 = "MP";
        ht.saveData(name2, "01099999999");
        System.out.printf("CloseHashTable | 이름 : %s | 값 : %s \r\n",name2,ht.getData(name2));
        System.out.printf("CloseHashTable | 이름 : %s | 값 : %s \r\n",name1,ht.getData(name1));

        String name3 = "HJ";
        ht.saveData(name3, "01088888888");
        System.out.printf("CloseHashTable | 이름 : %s | 값 : %s \r\n",name3,ht.getData(name3));
    }

}
