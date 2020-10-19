package com.company;

public class MyFloat
{
    private long mantissa;
    private long exponent;
    private long myInteger;
    private long myFraction;
    private long resultInteger;
    private long resultFraction;
    private long resultExp;

    public MyFloat(long mantissa, long exponent)
    {
        this.mantissa = mantissa;
        this.exponent = exponent;

        intFract();

        this.resultFraction = 0;
        this.resultInteger = 0;
    }

    private void intFract()
    {
        this.myInteger = (long)(this.mantissa / Math.pow(10, this.exponent));
        this.myFraction = (long)(this.mantissa % Math.pow(10, this.exponent));
    }



    public void sum(MyFloat b)
    {
        this.resultExp = this.exponent <= b.getExponent() ? b.getExponent() : this.exponent;

        if(this.exponent >= b.getExponent())
        {
            b.setMyFraction((long)(b.getMyFraction() * Math.pow(10, this.exponent - b.getExponent())));
        }
        else
        {
            this.myFraction *= (long)Math.pow(10, b.getExponent() - this.exponent);
        }

        this.resultFraction = this.myFraction + b.myFraction;

        this.resultInteger += this.resultFraction / (long)(Math.pow(10, this.resultExp));
        this.resultFraction = this.resultFraction % (long)(Math.pow(10, this.resultExp));

        this.resultInteger += (this.myInteger + b.getMyInteger());

        System.out.println(this.resultInteger + "." + this.resultFraction);
    }

    public long getMyInteger()
    {
        return myInteger;
    }

    public long getMyFraction()
    {
        return myFraction;
    }

    public void setMyFraction(long myFraction)
    {
        this.myFraction = myFraction;
    }

    public long getExponent()
    {
        return exponent;
    }


    public void dif(MyFloat b) {


        /*
        a - this.mantissa
        b - this.exponent

        x - b.mantissa
        y - b.exponent

        ac - this.resultInteger
        xo - this.resultFraction

        f = this.resultExp
         */

        long ac = (this.mantissa / (long)(Math.pow(10 , this.exponent)));
        long xc = (b.mantissa / (long)(Math.pow(10, b.exponent)));
        long ao = (this.mantissa % (long)(Math.pow(10, this.exponent)));
        long xo = (b.mantissa % (long)(Math.pow(10, b.exponent)));
        this.resultExp = 0;

        long n;
        long k;

        if (this.exponent > b.exponent) {
            this.resultExp = this.exponent - b.exponent;
            n = this.exponent;
            k = n;

            xo *= (long)Math.pow(10, this.resultExp);
        }
        else {
            this.resultExp = b.exponent - this.exponent;
            n = b.exponent;
            k = n;

            ao *= (long)Math.pow(10, this.resultExp);
        }
        this.resultInteger = ac - xc;
        this.resultFraction = ao - xo;


        if (this.resultFraction < 0) {

            if (this.resultInteger > 0) {
                this.resultInteger -= 1;
                this.resultFraction = ((long)(Math.pow(10, n))) - (Math.abs(this.resultFraction));
            }
            else if (this.resultInteger == 0) {
                System.out.println("-");
                this.resultFraction = Math.abs(this.resultFraction);
            }
           else {
               this.resultFraction = Math.abs(this.resultFraction);
            }
        }
        else {
            if (this.resultInteger < 0) {
                this.resultInteger++;
                this.resultFraction = ((long)(Math.pow(10, n))) - (Math.abs(this.resultFraction));
            }
        }
        for (long i = 1; i < n; i++) {

            if ((this.resultFraction % (long)(Math.pow(10, i))) == this.resultFraction) {
                k = i;
                break;
            }
        }
        if (k != n) {
            for (long i = k; i < n; i++) {
                System.out.println("0");
            }
        }
        System.out.println(this.resultInteger + "." + this.resultFraction);
    }
}
