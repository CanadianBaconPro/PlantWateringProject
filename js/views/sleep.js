

function sleeptime(ms) 
{
  return new Promise(resolve => setTimeout(resolve, ms));
}
  
async function sleep() 
{
  while(true)
  {
    await sleeptime(15000);
    location.reload(true/false);
  }
}
  
sleep();