<template>
  <div>

    <div class="adminButtons">
      <button v-on:click="displayTableEvent()" type="button" class="btn btn-primary btn-lg">Loo üritus</button>
      <button v-on:click="displayTableAllEvents()" type="button" class="btn btn-primary btn-lg">Kuva üritused</button>
    </div>

    <div v-if="this.displayAllEvents">

      <div v-if="showMessage" class="alert alert-success" role="alert">
        {{ addSuccessMessage }}
      </div>

      <table class="table table-hover">
        <thead id="eventTable">
        <tr>
          <th scope="col">#</th>
          <th scope="col">Kuupäev</th>
          <th scope="col">Kellaaeg</th>
          <th scope="col">Ürituse nimi</th>
          <th scope="col">Ettevõtte</th>
          <th scope="col">Koht</th>
          <th scope="col">Esineja</th>
        </tr>
        </thead>

        <tbody>
        <tr v-for="(event, index) in events">
          <th>{{ index + 1 }}</th>
          <td>{{ event.date }}</td>
          <td>{{ event.time }}</td>
          <td>{{ event.eventName }}</td>
          <td>{{ event.company }}</td>
          <td>{{ event.zoom }}</td>
          <td>{{ event.presenterName }}</td>

          <td style="float: right">
            <button type="submit" class="btn btn-primary btn-xs m-3"
                    @click="hideAllEvents(event.id)">Muuda
            </button>
            <button type="submit" class="btn btn-primary btn-xs"
                    @click="deleteEventById(event.id)">
              Kustuta
            </button>
          </td>
        </tr>
        </tbody>
      </table>
    </div>


    <div class="form" v-if="this.tableDivDisplay">
      <div class="form-group">
        <label class="label-form">Kuupäev</label>
        <input type="date" class="form-control" placeholder="Kuupäev" v-model="eventById.date">

        <label class="label-form">Ürituse kellaaeg</label>
        <input type="time" class="form-control" placeholder="Kellaaeg" v-model="eventById.time">

        <label class="label-form">Ürituse pealkiri</label>
        <input type="text" class="form-control" placeholder="Ürituse pealkiri" v-model="eventById.eventName">

        <label class="label-form">Ettevõte</label>
        <input type="text" class="form-control" placeholder="Ettevõtte nimi" v-model="eventById.company">

        <label class="label-form">Ürituse koht</label>
        <input type="text" class="form-control" placeholder="Kas klassis/zoom´i link." v-model="eventById.zoom">

        <label class="label-form">Esineja</label>
        <input type="text" class="form-control" placeholder="Esineja(te) nimi" v-model="eventById.presenterName">

        <button class="btn btn-primary m-3" v-if="!toggleButton" v-on:click="addNewEvent">Loo üritus</button>
        <button class="btn btn-primary m-3" v-if="toggleButton" v-on:click="updateEventAndResetView">Muuda</button>
      </div>

      <div>

      </div>
    </div>
  </div>

</template>

<script>
import EventForm from "@/components/EventForm";

export default {
  name: "AdminPageView",
  components: {EventForm},
  data: function () {
    return {

      event: {},
      tableDivDisplay: false,
      displayAllEvents: false,
      events: {},
      toggleButton: false,
      eventById: {},
      eventId: null,
      showMessage: false,
      addSuccessMessage: ``,

    }
  },
  methods: {

    refreshPage: function () {
      window.location.reload();
    },

    displayTableEvent: function () {
      this.tableDivDisplay = true
      this.displayAllEvents = false
      this.toggleButton = false

    },

    hideTableEvent: function () {
      this.tableDivDisplay = false
    },

    displayTableAllEvents: function () {
      this.displayAllEvents = true
      this.tableDivDisplay = false
      this.getAllEvents()
    },

    hideAllEvents: function (id) {
      this.displayAllEvents = false
      this.tableDivDisplay = true
      this.toggleButton = true
      this.eventId = id
      this.getEventById()
    },

    updateEvent: function () {
      this.$http.put("/event/update", this.eventById, {
            params: {
              eventId: this.eventId
            }
          }
      ).then(response => {
        console.log(response.data)
      }).catch(error => {
        console.log(error)
      })
    },

    updateEventAndResetView: function () {
      this.updateEvent()
      this.refreshPage()
      this.tableDivDisplay = false
      this.displayAllEvents = true
      this.toggleButton = false
    },

    addNewEvent: function () {

      this.$http.post("/event/add", this.eventById
      ).then(response => {
        this.refreshPage()
        this.hideTableEvent()
        console.log(response.data)
      }).catch(error => {
        console.log(error)
      })
    },

    getAllEvents: function () {
      this.$http.get("/event/all")
          .then(response => {
            this.events = response.data
            console.log(response.data)
          }).catch(error => {
        console.log(error)
      })
    },

    getEventById: function () {
      this.$http.get("/event/id", {
        params: {
          eventId: this.eventId
        }
      })
          .then(response => {
            this.eventById = response.data
            console.log(response.data)
          }).catch(error => {
        console.log(error)
      })
    },

    deleteEventById: async function (id) {
      await this.$http.delete("/event/delete", {
            params: {
              eventId: id
            }
          }
      ).then(response => {
        this.getAllEvents()
        this.showMessage = true
        this.addSuccessMessage = 'Üritus edukalt kustutatud.'
        console.log(response.data)
      }).catch(error => {
        console.log(error)
      })
    }
  },

  mounted () {
    this.getAllEvents()

  }
}

</script>

<style scoped>

.adminButtons {
  margin-top: 5vh;
  margin-bottom: 5vh;
}

.form {
  display: inline-block;
  margin: auto 98vh;
  margin-bottom: 10vh;
  /*border: 2px solid red;*/
  /*margin-right: 100px;*/
}

div.form {
  display: grid;
  grid-template-columns: max-content max-content;
  grid-gap: 10px;
}

div.form label {
  text-align: right;
  margin-top: 10px;
}

div.form label:after {
  content: ":";
}

.table table-hover {
  margin-bottom: 5vh;
}


</style>

