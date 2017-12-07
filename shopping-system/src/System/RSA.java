package System;
import java.math.BigInteger;
import java.security.SecureRandom;

public class RSA
{
	public BigInteger PubKey = null;// ��Կ
	public BigInteger PriKey = null;// ˽Կ
	public BigInteger n = null;// n = p * q 2048λ

	private BigInteger One = new BigInteger("1");

	public void CreateKey()// ����һ�Թ�˽Կ
	{
		BigInteger p = FindPrime();// ����p 1024λ
		BigInteger q = FindPrime();// ����q 1024λ
		n = p.multiply(q);// n = p * q
		BigInteger Fain = (p.subtract(One)).multiply(q.subtract(One));// ��(n) =(p - 1)(q- 1)
		PubKey = CreatePubKey(Fain);// ������Կ
		PriKey = CalcInverse(PubKey, Fain);// ����˽Կ(��Կ����Ԫ)
	}

	public static String Encrypt(String val, BigInteger key, BigInteger moder)// �ӽ���
	{
		BigInteger Val = new BigInteger(val);// ��String���͵�����ת����BigInteger����
		Val = Val.mod(moder);
		BigInteger Output = null;
		// ִ�мӽ��ܲ���
		Output = Val.modPow(key, moder);
		// �ӽ������
		return Output.toString();
	}

	private BigInteger FindPrime()// ����һ������Ĵ����� 1024λ
	{
		SecureRandom rnd = new SecureRandom();// �����Դ
		BigInteger big_prime;
		int bitlength = 1024;
		big_prime = BigInteger.probablePrime(bitlength, rnd);// 1024bit�ĳ�����
		return big_prime;
	}

	private BigInteger CreatePubKey(BigInteger Fain)// ���ɹ�Կ���㷨δ����
	{
		// ����(e,n)
		BigInteger init_val = new BigInteger("65537");
		if (Fain.gcd(init_val).intValue() == 1)
		{
			return init_val;
		} // ����
		else
		{
			do
			{
				BigInteger val;
				val = init_val.nextProbablePrime();// �ҵ���һ������
				if (Fain.gcd(val).intValue() == 1)
				{
					System.out.println(val);// ��ӡe
					return val;
				}

			} while (true);
		}
	}

	private static BigInteger CalcInverse(BigInteger value, BigInteger moder)// ��valueģmoder����
	{
		BigInteger i1 = BigInteger.valueOf(1);
		BigInteger i2 = BigInteger.valueOf(0);
		BigInteger j1 = BigInteger.valueOf(0);
		BigInteger j2 = BigInteger.valueOf(1);
		BigInteger a = value, b = moder;
		BigInteger q = BigInteger.valueOf(0);
		BigInteger temp = BigInteger.valueOf(0);
		BigInteger tempi = BigInteger.valueOf(0);
		BigInteger tempj = BigInteger.valueOf(0);
		// ���gcd ==1
		// ���a>b
		while (b.compareTo(BigInteger.valueOf(1)) != 0)
		{
			q = a.divide(b);
			temp = b;
			b = a.remainder(b);
			a = temp;
			tempi = i2;
			tempj = j2;
			i2 = i1.subtract(q.multiply(i2));
			j2 = j1.subtract(j2.multiply(q));
			i1 = tempi;
			j2 = tempj;
		}
		if (i2.compareTo(BigInteger.valueOf(0)) == -1)
		{
			i2 = i2.add(moder);
		}
		return i2;
	}
}
