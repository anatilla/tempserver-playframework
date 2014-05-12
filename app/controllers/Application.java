package controllers;

import measurator.MeasureService;
import models.Measurement;
import models.MeasurementType;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import utils.DateValidator;
import utils.MeasurementJSONTemplate;
import utils.Sensors;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class Application extends Controller {

    public static Result getActualTemp() {
        Map<MeasurementType, String[]> cmds = Sensors.getSensors();
        Measurement measurement = MeasureService.getMeasurement(cmds);
        MeasurementJSONTemplate jsonTemplate = new MeasurementJSONTemplate();
        jsonTemplate.add(measurement);

        return ok(Json.toJson(jsonTemplate));
    }

    @Transactional
    public static Result getLogTemp(int num, String date) {
        Date d = DateValidator.validateDate(date);

        if (d == null) {
            return badRequest("malformed date");
        }
        MeasurementJSONTemplate template = new MeasurementJSONTemplate();
        List<Measurement> results = Measurement.findAllSince(d.getTime(), num);
        template.addAll(results);

        return ok(Json.toJson(template));
    }

    public static Result renderActualPlot() {
        return ok(views.html.plot.render());
    }

    public static Result renderLogPlot() {
        return ok(views.html.logplot.render());
    }
}
