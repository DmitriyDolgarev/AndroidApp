package Logic;

import android.content.Context;

import androidx.annotation.AnyRes;

import com.example.myapplication.R;

public class Calculator {
    private Context context;
    public Calculator(Context context)
    {
        this.context = context;
    }
    public String getValue(int horsePower)
    {
        double rent = 0;

        int lower = context.getResources().getInteger(R.integer.lower);
        int middleLower = context.getResources().getInteger(R.integer.middleLower);
        int middleHigher = context.getResources().getInteger(R.integer.middleHigher);
        int higher = context.getResources().getInteger(R.integer.higher);

        double lowerCoef = context.getResources().getInteger(R.integer.lowerCoef);
        double middleLowerCoef = context.getResources().getInteger(R.integer.middleLowerCoef);
        double middleHigherCoef = context.getResources().getInteger(R.integer.middleHigherCoef);
        double higherCoef = context.getResources().getInteger(R.integer.higherCoef);
        double veryHigherCoef = context.getResources().getInteger(R.integer.veryHigherCoef);

        if (horsePower < lower)
        {
            rent = horsePower * lowerCoef / 10;
        }
        else if (horsePower < middleLower)
        {
            rent = horsePower * middleLowerCoef / 10;
        }
        else if (horsePower < middleHigher)
        {
            rent = horsePower * middleHigherCoef / 10;
        }
        else if (horsePower < higher)
        {
            rent = horsePower * higherCoef / 10;
        }
        else
        {
            rent = horsePower * veryHigherCoef / 10;
        }

        return "" + rent;
    }
}
