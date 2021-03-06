package pl.kania.trendminer.db.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@EqualsAndHashCode(of = "id")
public class TimeId  {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "START_TIME")
    private LocalDateTime startTime;

    @Column(name = "END_TIME")
    private LocalDateTime endTime;

    /**
     * Number of documents processed in that update period.
     */
    @Column(name = "DOC_FREQ")
    private Long docFreq;

    @Column(name = "PERIOD_INDEX")
    private int index;

    @Override
    public String toString() {
        return "#" + index + " [" + (startTime == null ? "?" : startTime.toString()) + ", " + (endTime == null ? "?" : endTime.toString()) + "]";
    }
}
