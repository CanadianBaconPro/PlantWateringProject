function sleeptime(ms) 
{
  return new Promise(resolve => setTimeout(resolve, ms));
}
  
async function sleep() 
{
  while(true)
  {
    await sleeptime(4000);
    window.location = "/";
  }
}

sleep();