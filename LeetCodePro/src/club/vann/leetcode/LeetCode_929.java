package club.vann.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode_929 {

	public static void main(String[] args) {
		String[] emails = { "test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com",
				"testemail+david@lee.tcode.com" };
		String[] emails1 = { "j+ezsorqlmc@rfpycgjuf.com", "j+k+ri+rigt.ad@rfpycgjuf.com", "hfmeqzk.isx+i@fiidmdrsu.com",
				"j+p+h+d+d+p+z.j.k.g@rfpycgjuf.com", "zygekdy.l.w+s@snh.owpyu.com", "j+m.l+ia+qdgv+w@rfpycgjuf.com",
				"r+hwbjwefkp@wcjaki.n.com", "zygekdy.l.w+d@snh.owpyu.com", "bizdm+sz.f.a.k@il.cjjlp.com",
				"hfmeqzk.isx+t@fiidmdrsu.com", "hfmeqzk.isx+i@fiidmdrsu.com", "bizdm+f+j+m.l.l@il.cjjlp.com",
				"zygekdy.l.w+g@snh.owpyu.com", "r+evgvxmksf@wcjaki.n.com", "hfmeqzk.isx+h@fiidmdrsu.com",
				"bizdm+lov+cy@il.cjjlp.com", "hfmeqzk.isx+o@fiidmdrsu.com", "bizdm+hs+qao@il.cjjlp.com",
				"r+v+z+rcuznrj@wcjaki.n.com", "j+r.kn+h.w.a.h+bh@rfpycgjuf.com", "hfmeqzk.isx+t@fiidmdrsu.com",
				"hfmeqzk.isx+a@fiidmdrsu.com", "zygekdy.l.w+o@snh.owpyu.com", "zygekdy.l.w+i@snh.owpyu.com",
				"r+vy.u.y+f.er+aw@wcjaki.n.com", "zygekdy.l.w+c@snh.owpyu.com", "bizdm+wztzg@il.cjjlp.com",
				"j+h.fwbsr+chp@rfpycgjuf.com", "zygekdy.l.w+s@snh.owpyu.com", "zygekdy.l.w+d@snh.owpyu.com",
				"bizdm+qq.o.q+p@il.cjjlp.com", "zygekdy.l.w+o@snh.owpyu.com", "j+c+zqbq+h.dyt@rfpycgjuf.com",
				"r+hl.b.i+fz.hz.t@wcjaki.n.com", "r+cbabpf.k+w+e@wcjaki.n.com" };
		
		String[] emails2 = {"test.email+alex@leetcode.com","test.email.leet+alex@code.com"};
		
		// j@rfpycgjuf.com
		// hfmeqzkisx@fiidmdrsu.com
		// zygekdylw@snh.owpyu.com
		// r@wcjaki.n.com
		// bizdm@il.cjjlp.com
		// 
		// 

		LeetCode_929 leetCode = new LeetCode_929();
		int result = leetCode.numUniqueEmails(emails2);

		System.out.println(result);
	}

	private int numUniqueEmails(String[] emails) {
		int len = emails.length;
		Set<String> set = new HashSet<String>();

		String mail = null;
		for (int n = 0; n < len; n++) {
			mail = emails[n];
			String[] mails = mail.split("@");
			if (mails[0].contains(".")) {
				mails[0] = mails[0].replaceAll("\\.", "");
			}
			if (mails[0].contains("+")) {
				mails[0] = mails[0].substring(0, mails[0].indexOf("+"));
			}

			set.add(mails[0] +"@"+ mails[1]);
		}

		return set.size();
	}

}
