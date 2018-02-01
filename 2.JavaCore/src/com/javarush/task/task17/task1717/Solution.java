package com.javarush.task.task17.task1717;

/* 
Лишняя синхронизация
*/

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;

public class Solution {
    char[] value;
    int count;

    public Solution append(CharSequence s) {
        if (s == null)
            s = "null";
        if (s instanceof String)
            return this.append((String) s);
        if (s instanceof Solution)
            return this.appendThis((Solution) s);
        return this.append(s);
    }

    public synchronized Solution appendThis(Solution s) {
        //do something here....
        return this;
    }

    private static final ObjectStreamField[] serialPersistentFields = {
            new ObjectStreamField("value", char[].class),
            new ObjectStreamField("count", Integer.TYPE),
            new ObjectStreamField("shared", Boolean.TYPE) };

    private synchronized void writeObject(ObjectOutputStream s) throws java.io.IOException {
        ObjectOutputStream.PutField fields = s.putFields();
        fields.put("value", value);
        fields.put("count", count);
        fields.put("shared", false);
        s.writeFields();
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField fields = s.readFields();
        value = (char[]) fields.get("value", null);
        count = fields.get("count", 0);
    }

    public static void main(String[] args) { }
}
