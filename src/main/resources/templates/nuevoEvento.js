function newEventoVarios(title, content, categ, FeInicio, FeFin) {
    $("#calendar").evoCalendar('addCalendarEvent', [
        {
          id: "evento "+title,
          name: title,
          badge: categ,
          description: content,
          date: [FeInicio,FeFin],
          type: categ,
        }
      ]);
}
function newEvento(title, content, categ, Fec) {
  $("#calendar").evoCalendar('addCalendarEvent', [
      {
        id: "evento "+title,
        name: title,
        badge: categ,
        description: content,
        date: Fec,
        type: categ,
      }
    ]);
}