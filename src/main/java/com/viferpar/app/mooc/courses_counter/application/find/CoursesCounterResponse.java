package com.viferpar.app.mooc.courses_counter.application.find;

import com.viferpar.app.shared.domain.bus.query.Response;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public final class CoursesCounterResponse implements Response {

    private Integer total;

}
