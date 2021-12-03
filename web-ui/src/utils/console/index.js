const appConsole = {
  log(msg) {
    // console.log(process.env)
    if (process.env.NODE_ENV !== "production") {
      console.log(msg)
    }
  },
}
export default appConsole
