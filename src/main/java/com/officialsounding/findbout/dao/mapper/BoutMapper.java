package com.officialsounding.findbout.dao.mapper;

import com.officialsounding.findbout.model.Bout;
import com.officialsounding.findbout.model.Team;
import org.joda.time.LocalDate;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BoutMapper implements ResultSetMapper<Bout>{
    @Override
    public Bout map(int index, ResultSet r, StatementContext ctx) throws SQLException {

        Bout b = new Bout();

        b.setDate(new LocalDate(r.getDate("date").getTime()));
        b.setSanctionedBy(r.getString("sanctioned_by"));

        Team home = new Team();
        Team away = new Team();

        home.setId(r.getInt("home_id"));
        home.setName(r.getString("home_name"));
        home.setLocationText(r.getString("home_location"));
        home.setUrl(r.getString("home_url"));
        home.setLat(r.getDouble("home_lat"));
        home.setLng(r.getDouble("home_lng"));


        away.setId(r.getInt("away_id"));
        away.setName(r.getString("away_name"));
        away.setLocationText(r.getString("away_location"));
        away.setLat(r.getDouble("away_lat"));
        away.setLng(r.getDouble("away_lng"));


        b.setHome(home);
        b.setAway(away);

        return b;
    }
}
