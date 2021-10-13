<template>
  <div style="height: 50px;line-height: 50px;border-bottom: 1px solid #ccc;display: flex">
    <div class="header-left">
      <el-button @click="collapse">侧边收缩</el-button>
    </div>
    <div class="header-middle"></div>
    <div class="header-right">
      <el-dropdown>
        <span class="el-dropdown-link">
          {{ user.username }}
          <i class="el-icon-arrow-down el-icon--right"></i>
        </span>
        <template #dropdown>
          <el-dropdown-menu>
            <el-dropdown-item>个人中心</el-dropdown-item>
            <el-dropdown-item>Action 2</el-dropdown-item>
            <el-dropdown-item>Action 3</el-dropdown-item>
            <el-dropdown-item disabled>Action 4</el-dropdown-item>
            <el-dropdown-item divided>退出登陆</el-dropdown-item>
          </el-dropdown-menu>
        </template>
      </el-dropdown>
    </div>
  </div>
</template>

<script>
export default {
  name: "Header",
  data() {
    return {
      user: {
        username: "张三"
      }
    }
  },
  methods:{
    collapse() {
      console.log(this.isCollapse)
      this.isCollapse.value =!this.isCollapse.value
    }
  },
  inject:['isCollapse']
}
</script>

<style scoped>
.header-left {
  width: 200px;
  text-align: left;
  padding-left: 20px;
}

.header-middle {
  flex: 1;
}

.header-right {
  width: 200px;
  text-align: right;
  padding-right: 20px;
}
</style>
