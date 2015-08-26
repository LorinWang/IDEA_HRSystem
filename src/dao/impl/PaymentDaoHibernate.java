package dao.impl;

import dao.PaymentDao;
import domain.Employee;
import domain.Payment;
import tools.DaoSupport;

import java.util.List;

/**
 * Created by Lorin on 2015/8/26.
 */
public class PaymentDaoHibernate extends DaoSupport implements PaymentDao {
    /**
     * ���ݱ�ʶ����������Paymentʵ��
     *
     * @param id ��Ҫ���ص�Paymentʵ���ı�ʶ����ֵ
     * @return ָ����ʶ���Զ�Ӧ��Paymentʵ��
     */
    public Payment get(Integer id) {
        return getHibernateTemplate()
                .get(Payment.class, id);
    }

    /**
     * �־û�ָ����Paymentʵ��
     *
     * @param payment ��Ҫ���־û���Paymentʵ��
     * @return Paymentʵ�����־û���ı�ʶ����ֵ
     */
    public Integer save(Payment payment) {
        return (Integer) getHibernateTemplate()
                .save(payment);
    }

    /**
     * �޸�ָ����Paymentʵ��
     *
     * @param payment ��Ҫ���޸ĵ�Paymentʵ��
     */
    public void update(Payment payment) {
        getHibernateTemplate()
                .update(payment);
    }

    /**
     * ɾ��ָ����Paymentʵ��
     *
     * @param payment ��Ҫ��ɾ����Paymentʵ��
     */
    public void delete(Payment payment) {
        getHibernateTemplate()
                .delete(payment);
    }

    /**
     * ���ݱ�ʶ����ɾ��Paymentʵ��
     *
     * @param id ��Ҫ��ɾ����Paymentʵ���ı�ʶ����ֵ
     */
    public void delete(Integer id) {
        getHibernateTemplate()
                .delete(get(id));
    }

    /**
     * ��ѯȫ����Paymentʵ��
     *
     * @return ���ݿ���ȫ����Paymentʵ��
     */
    public List<Payment> findAll() {
        return (List<Payment>) getHibernateTemplate()
                .find("from Payment");
    }

    /**
     * ����Ա����ѯ�½�нˮ
     *
     * @return ��Ա����Ӧ���½�нˮ����
     */
    public List<Payment> findByEmp(Employee emp) {
        return (List<Payment>) getHibernateTemplate()
                .find("from Payment as p where p.employee=?", emp);
    }


    /**
     * ����Ա���ͷ�н�·�����ѯ�½�нˮ
     *
     * @param payMonth ��н�·�
     * @param emp      ��н��Ա��
     * @return ָ��Ա����ָ���·ݵ��½�нˮ
     */
    public Payment findByMonthAndEmp(String payMonth
            , Employee emp) {
        List<Payment> pays = (List<Payment>) getHibernateTemplate()
                .find("from Payment as p where p.employee=? and p.payMonth=?", new Object[]{emp, payMonth});
        if (pays != null && pays.size() > 0) {
            return pays.get(0);
        }
        return null;
    }
}
