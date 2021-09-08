package prob03;

public class CurrencyConverter {
	   private static double rate;

	   public static double  toDollar(double won) {
	      // 한국 원화를 달러로 변환
		   double dollar;
		   dollar = won / rate;
		   return dollar;
	   }
	   public static double  toKRW(double dollar) {
	      // 달러를 한국 원화로 변환
		   double KRW;
		   KRW = dollar * rate;
		   return KRW;
	   }
	   public static void setRate(double r) {
	       rate = r;
	   }
	}
