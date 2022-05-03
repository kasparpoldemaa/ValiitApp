<template>

  <form>

    <div class="form-group">
      <label class="label-form">Kuupäev</label>
      <input type="date" class="form-control" placeholder="Kuupäev" v-model="event.date">

      <label class="label-form">Ürituse kellaaeg</label>
      <input type="time" class="form-control" placeholder="Kellaaeg" v-model="event.time">

      <label class="label-form">Ürituse pealkiri</label>
      <input type="text" class="form-control" placeholder="Ürituse pealkiri" v-model="event.eventName">

      <label class="label-form">Ettevõte</label>
      <input type="text" class="form-control" placeholder="Ettevõtte nimi" v-model="event.company">

      <label class="label-form">Ürituse koht</label>
      <input type="text" class="form-control" placeholder="Kas klassis/zoom´i link." v-model="event.zoom">

      <label class="label-form">Esineja</label>
      <input type="text" class="form-control" placeholder="Esineja(te) nimi" v-model="event.presenterName">

    </div>

    <button class="btn btn-primary" v-on:click="addNewEvent">Submit</button>
  </form>
</template>

<script>
export default {
  name: "EventView",
  data: function () {
    return{

      event:{}
    }
  },
  methods:{
    addNewEvent: function () {

      this.$http.post("/event/add", this.event
      ).then(response => {
        console.log(response.data)
      }).catch(error => {
        console.log(error)
      })
    }
  }


}
</script>

<style scoped>
form {
  display: inline-block;
  margin-right: 100px;
}

div.form-group {
  display:grid;
  grid-template-columns: max-content max-content;
  grid-gap:10px;
}
div.form-group label       { text-align:right;
  margin-top: 10px}
div.form-group label:after { content: ":"; }


</style>