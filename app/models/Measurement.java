package models;

import play.db.jpa.JPA;

import javax.persistence.*;
import java.util.List;

/**
 * Author: alexander
 * Project: tempserver-playframework
 */

@Entity
@Table(name = "measurement")
public class Measurement {

    @Id
    @Column(name = "unix_time")
    private Long unix_time;

    @Column(name = "external")
    private Float external;

    @Column(name = "mobo")
    private Float mobo;

    @Column(name = "core")
    private Float core;

    public Measurement() {
    }

    public Measurement(Long unix_time, Float external, Float mobo, Float core) {
        this.unix_time = unix_time;
        this.external = external;
        this.mobo = mobo;
        this.core = core;
    }

    public Long getUnix_time() {
        return unix_time;
    }

    public void setUnix_time(Long unix_time) {
        this.unix_time = unix_time;
    }

    public Float getExternal() {
        return external;
    }

    public void setExternal(Float external) {
        this.external = external;
    }

    public Float getMobo() {
        return mobo;
    }

    public void setMobo(Float mobo) {
        this.mobo = mobo;
    }

    public Float getCore() {
        return core;
    }

    public void setCore(Float core) {
        this.core = core;
    }

    public boolean save() {
        boolean result;
        EntityManager entityManager = JPA.em().getEntityManagerFactory().createEntityManager();

        try {

            entityManager.getTransaction().begin();
            entityManager.persist(this);
            entityManager.getTransaction().commit();
            result = true;
        } catch (PersistenceException exception) {
            result = false;
        } finally {
            entityManager.close();
        }

        return result;
    }

    public static List findAll() {
        return JPA.em().createQuery("from Measurement order by unix_time").getResultList();
    }

    public static List findAllSince(Long time, int lim) {
        Query q = JPA.em().createQuery("from Measurement where unix_time > :time order by unix_time");

        if (lim < 0) {
            q.setParameter("time", time);
            return q.getResultList();
        } else {
            q.setParameter("time", time).setMaxResults(lim);
            return q.getResultList();
        }
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Measurement{");
        sb.append("unix_time=").append(unix_time);
        sb.append(", external=").append(external);
        sb.append(", mobo=").append(mobo);
        sb.append(", core=").append(core);
        sb.append('}');
        return sb.toString();
    }
}
