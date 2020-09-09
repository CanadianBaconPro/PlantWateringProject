function sleeptime(ms) 
{
  return new Promise(resolve => setTimeout(resolve, ms));
}
  
async function sleep() 
{
  while(true)
  {
    await sleeptime(20000);
    location.reload(true/false);
  }
}
  
sleep();