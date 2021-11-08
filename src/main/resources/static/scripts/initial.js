$(document).ready(function () {
    $('#calendar').evoCalendar({
        
        theme:"Midnight Blue",
        calendarEvents: [
            {
                id: 'event1', // Event's ID (required)
                name: "New Year", // Event name (required)
                date: "January/1/2021", // Event date (required)
                description: "feliz año nuevo",
                type: "holiday", // Event type (required)
                everyYear: true // Same event every year (optional)
            },
            {
                id: 'event 2',
                name: "Vacation Leave",
                badge: "02/13 - 02/15", // Event badge (optional)
                date: ["February/13/2021", "February/15/2021"], // Date range
                description: "Vacation leave for 3 days.", // Event description (optional)
                type: "event",
                color: "#63d867" // Event custom color (optional)
            }
        ]
    })
})
