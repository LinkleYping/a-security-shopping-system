package System;
import java.math.BigInteger;
import java.security.SecureRandom;

public class RSA
{
	public BigInteger PubKey = null;// 公钥
	public BigInteger PriKey = null;// 私钥
	public BigInteger n = null;// n = p * q 2048位

	private BigInteger One = new BigInteger("1");

	public void CreateKey()// 生成一对公私钥
	{
		BigInteger p = FindPrime();// 生成p 1024位
		BigInteger q = FindPrime();// 生成q 1024位
		n = p.multiply(q);// n = p * q
		BigInteger Fain = (p.subtract(One)).multiply(q.subtract(One));// φ(n) =(p - 1)(q- 1)
		PubKey = CreatePubKey(Fain);// 创建公钥
		PriKey = CalcInverse(PubKey, Fain);// 计算私钥(公钥的逆元)
	}

	public static String Encrypt(String val, BigInteger key, BigInteger moder)// 加解密
	{
		BigInteger Val = new BigInteger(val);// 把String类型的数据转换成BigInteger类型
		Val = Val.mod(moder);
		BigInteger Output = null;
		// 执行加解密操作
		Output = Val.modPow(key, moder);
		// 加解密完毕
		return Output.toString();
	}

	private BigInteger FindPrime()// 生成一个随机的大素数 1024位
	{
		SecureRandom rnd = new SecureRandom();// 随机数源
		BigInteger big_prime;
		int bitlength = 1024;
		big_prime = BigInteger.probablePrime(bitlength, rnd);// 1024bit的长素数
		return big_prime;
	}

	private BigInteger CreatePubKey(BigInteger Fain)// 生成公钥（算法未定）
	{
		// 返回(e,n)
		BigInteger init_val = new BigInteger("65537");
		if (Fain.gcd(init_val).intValue() == 1)
		{
			return init_val;
		} // 互素
		else
		{
			do
			{
				BigInteger val;
				val = init_val.nextProbablePrime();// 找到下一个素数
				if (Fain.gcd(val).intValue() == 1)
				{
					System.out.println(val);// 打印e
					return val;
				}

			} while (true);
		}
	}

	private static BigInteger CalcInverse(BigInteger value, BigInteger moder)// 求value模moder的逆
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
		// 检查gcd ==1
		// 检查a>b
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
