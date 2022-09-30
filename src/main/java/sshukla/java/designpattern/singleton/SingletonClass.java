package sshukla.java.designpattern.singleton;

import java.io.Serializable;

/**
 * @author 'Seemant Shukla' on '28/09/2022'
 */

// One the object is created it should always be used.
public class SingletonClass implements Serializable, Cloneable {

    private static SingletonClass INSTANCE_VARIABLE;

    private SingletonClass() {
        if (INSTANCE_VARIABLE != null) {
            throw new RuntimeException("Do not try to break the Singleton class");
        }
    }

    public SingletonClass getInstance() {
        if (INSTANCE_VARIABLE == null) {
            synchronized (SingletonClass.class) {
                INSTANCE_VARIABLE = new SingletonClass();
            }
        }
        return INSTANCE_VARIABLE;
    }

    protected Object readResolve() {
        return INSTANCE_VARIABLE;
    }

    @Override
    public SingletonClass clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Cloning not supported!!!");
    }
}
