<template>
  <div class="home">
    <div>
      <el-table :data="tableData" border style="width: 100%">
        <el-table-column prop="date" label="Date" width="180"/>
        <el-table-column prop="name" label="Name" width="180"/>
        <el-table-column prop="address" label="Address"/>
      </el-table>
    </div>

  </div>
</template>

<script>
// @ is an alias to /src

export default {
  name: "Home",
  components: {},
  data() {
    return {
      tableData: [
        {
          date: "2016-05-03",
          name: "Tom",
          address: "No. 189, Grove St, Los Angeles",
        },
        {
          date: "2016-05-02",
          name: "Tom",
          address: "No. 189, Grove St, Los Angeles",
        },
      ],
    }
  },

  methods: {},
}
</script>
<style lang="scss">
.home {
  padding: 10px;
  height: calc(100vh - 50px);
}
</style>
