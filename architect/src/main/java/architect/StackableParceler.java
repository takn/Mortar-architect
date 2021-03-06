package architect;

import android.os.Parcelable;

/**
 * @author Lukasz Piliszczuk - lukasz.pili@gmail.com
 */
public interface StackableParceler<T extends StackablePath> {

    Parcelable wrap(T path);

    T unwrap(Parcelable parcelable);
}
