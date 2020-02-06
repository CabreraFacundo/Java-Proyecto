package model;

import java.util.Date;
import java.util.SplittableRandom;

public interface ISchedulable {

    void schedule(Date date, String time);
}
